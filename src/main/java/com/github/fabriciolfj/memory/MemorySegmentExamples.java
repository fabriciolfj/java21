package com.github.fabriciolfj.memory;

import java.lang.foreign.*;
import java.lang.invoke.VarHandle;
import static java.lang.foreign.ValueLayout.*;

public class MemorySegmentExamples {

    public static void main(String[] args) {
        exemploBasicoMemorySegment();
        exemploComOffsets();
        exemploComStructs();
        exemploMemoryMappedFile();
    }

    // Exemplo 1: Criando e usando memory segments básicos
    public static void exemploBasicoMemorySegment() {
        System.out.println("=== Exemplo 1: Memory Segment Básico ===");

        // Criando um segment na memória nativa (off-heap) de 64 bytes
        try (Arena arena = Arena.ofConfined()) {
            MemorySegment segment = arena.allocate(64);

            System.out.println("Tamanho do segment: " + segment.byteSize());
            System.out.println("Endereço base: " + segment.address());

            // Escrevendo valores em diferentes offsets
            segment.set(JAVA_INT, 0, 42);        // offset 0: int = 42
            segment.set(JAVA_INT, 4, 100);       // offset 4: int = 100
            segment.set(JAVA_LONG, 8, 12345L);   // offset 8: long = 12345

            // Lendo os valores
            int valor1 = segment.get(JAVA_INT, 0);
            int valor2 = segment.get(JAVA_INT, 4);
            long valor3 = segment.get(JAVA_LONG, 8);

            System.out.println("Valor no offset 0: " + valor1);
            System.out.println("Valor no offset 4: " + valor2);
            System.out.println("Valor no offset 8: " + valor3);
        }
    }

    // Exemplo 2: Trabalhando com diferentes offsets
    public static void exemploComOffsets() {
        System.out.println("\n=== Exemplo 2: Offsets Detalhados ===");

        try (Arena arena = Arena.ofConfined()) {
            MemorySegment segment = arena.allocate(100);

            // Simulando um array de inteiros
            int[] valores = {10, 20, 30, 40, 50};

            // Escrevendo array com offsets calculados
            for (int i = 0; i < valores.length; i++) {
                long offset = i * JAVA_INT.byteSize(); // 4 bytes por int
                segment.set(JAVA_INT, offset, valores[i]);
                System.out.println("Escrito " + valores[i] + " no offset " + offset);
            }

            System.out.println();

            // Lendo de volta com offsets
            for (int i = 0; i < valores.length; i++) {
                long offset = i * JAVA_INT.byteSize();
                int valor = segment.get(JAVA_INT, offset);
                MemorySegment enderecoEspecifico = segment.asSlice(offset, JAVA_INT.byteSize());

                System.out.println("Offset " + offset + ": valor=" + valor +
                        ", endereço=" + enderecoEspecifico.address());
            }
        }
    }

    // Exemplo 3: Simulando uma struct C com offsets
    public static void exemploComStructs() {
        System.out.println("\n=== Exemplo 3: Struct com Offsets ===");

        // Simulando uma struct:
        // struct Person {
        //     int id;        // offset 0, 4 bytes
        //     double salary; // offset 8, 8 bytes (alinhamento!)
        //     int age;       // offset 16, 4 bytes
        // }

        try (Arena arena = Arena.ofConfined()) {
            // Layout da struct
            GroupLayout personLayout = MemoryLayout.structLayout(
                    JAVA_INT.withName("id"),           // offset 0
                    MemoryLayout.paddingLayout(4),     // padding para alinhamento
                    JAVA_DOUBLE.withName("salary"),    // offset 8
                    JAVA_INT.withName("age")           // offset 16
            );

            MemorySegment person = arena.allocate(personLayout);

            // Calculando offsets
            long idOffset = personLayout.byteOffset(MemoryLayout.PathElement.groupElement("id"));
            long salaryOffset = personLayout.byteOffset(MemoryLayout.PathElement.groupElement("salary"));
            long ageOffset = personLayout.byteOffset(MemoryLayout.PathElement.groupElement("age"));

            System.out.println("Offset do ID: " + idOffset);
            System.out.println("Offset do Salary: " + salaryOffset);
            System.out.println("Offset da Age: " + ageOffset);
            System.out.println("Tamanho total da struct: " + personLayout.byteSize());

            // Preenchendo a struct
            person.set(JAVA_INT, idOffset, 1001);
            person.set(JAVA_DOUBLE, salaryOffset, 75000.50);
            person.set(JAVA_INT, ageOffset, 30);

            // Lendo a struct
            System.out.println("Person ID: " + person.get(JAVA_INT, idOffset));
            System.out.println("Person Salary: " + person.get(JAVA_DOUBLE, salaryOffset));
            System.out.println("Person Age: " + person.get(JAVA_INT, ageOffset));
        }
    }

    // Exemplo 4: Slice e endereços específicos
    public static void exemploMemoryMappedFile() {
        System.out.println("\n=== Exemplo 4: Slices e Endereços ===");

        try (Arena arena = Arena.ofConfined()) {
            MemorySegment buffer = arena.allocate(1000);

            // Criando "slices" (fatias) do buffer original
            MemorySegment header = buffer.asSlice(0, 64);        // primeiros 64 bytes
            MemorySegment data = buffer.asSlice(64, 500);        // próximos 500 bytes
            MemorySegment footer = buffer.asSlice(564, 100);     // últimos 100 bytes

            System.out.println("Buffer principal - Endereço: " + buffer.address() +
                    ", Tamanho: " + buffer.byteSize());
            System.out.println("Header - Endereço: " + header.address() +
                    ", Tamanho: " + header.byteSize());
            System.out.println("Data - Endereço: " + data.address() +
                    ", Tamanho: " + data.byteSize());
            System.out.println("Footer - Endereço: " + footer.address() +
                    ", Tamanho: " + footer.byteSize());

            // Diferenças de endereços (offsets)
            System.out.println("Offset do Data: " + (data.address() - buffer.address()));
            System.out.println("Offset do Footer: " + (footer.address() - buffer.address()));

            // Usando VarHandle para acesso mais eficiente
            VarHandle intHandle = JAVA_INT.varHandle();

            // Escrevendo no header usando VarHandle
            intHandle.set(header, 0L, 0xDEADBEEF);  // magic number no início
            intHandle.set(data, 0L, 12345);         // primeiro int dos dados

            System.out.println("Magic number no header: 0x" +
                    Integer.toHexString((Integer) intHandle.get(header, 0L)));
            System.out.println("Primeiro int dos dados: " +
                    intHandle.get(data, 0L));
        }
    }
}