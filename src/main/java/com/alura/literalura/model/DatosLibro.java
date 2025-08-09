package com.alura.literalura.model;

import java.util.List;
import java.util.Map;

public record DatosLibro(
        int id,
        String title,
        List<DatosAutor> authors,
        List<String> summaries,
        List<String> translators,
        List<String> subjects,
        List<String> bookshelves,
        List<String> languages,
        boolean copyright,
        String media_type,
        Map<String, String> formats,
        int download_count
) {}
