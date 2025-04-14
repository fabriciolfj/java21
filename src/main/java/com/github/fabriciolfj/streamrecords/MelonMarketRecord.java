package com.github.fabriciolfj.streamrecords;

import com.github.fabriciolfj.reflectionrecord.MelonRecord;

import java.util.List;

public record MelonMarketRecord(List<MelonRecord> melons, String country) { }
