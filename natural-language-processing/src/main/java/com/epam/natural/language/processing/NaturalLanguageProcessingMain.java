package com.epam.natural.language.processing;

import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class NaturalLanguageProcessingMain {

    public static void main(String[] args) throws IOException, TikaException {
        for (int index = 0; index < 100000; index++) {
            Tika tika = new Tika();
            String text = tika.parseToString(Paths.get("C:/_stefan/share/geri-nikol.txt"));
            Annotation document = new Annotation(text);

            Properties properties = new Properties();
            properties.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
            StanfordCoreNLP pipeline = new StanfordCoreNLP(properties);
            pipeline.annotate(document);
        }
    }

}
