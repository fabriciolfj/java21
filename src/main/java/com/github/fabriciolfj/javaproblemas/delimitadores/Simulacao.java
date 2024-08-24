package com.github.fabriciolfj.javaproblemas.delimitadores;

public class Simulacao {

    public static void main(String[] args) {
        String sql = """
                UPDATE "public"."office"
                SET ("address_first", "address_second", "phone") =
                  (SELECT "public"."employee"."first_name",
                          "public"."employee"."last_name", ?
                   FROM "public"."employee"
                   WHERE "public"."employee"."job_title" = ?
                                                 """;

        System.out.println(sql);

        String poem = """
              I would want to establish strength; root-like,
              anchored in the hopes of solidity.
              Forsake the contamination of instability.
              Prove I'm the poet of each line of prose."""
                .indent(6) //acrescenta 6 espaços no inicio de cada linha
                .stripTrailing(); //tira a ultima linha em branco

        System.out.println(poem);
    }
}
