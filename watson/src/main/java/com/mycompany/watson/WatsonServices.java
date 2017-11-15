/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.watson;

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.language_translator.v2.LanguageTranslator;
import com.ibm.watson.developer_cloud.language_translator.v2.model.Language;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslationResult;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EntitiesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
import com.ibm.watson.developer_cloud.personality_insights.v3.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.ProfileOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyOptions;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author Oscar
 */
public class WatsonServices {

    final String transaleUser = "cc71a7c3-e69f-4054-bb95-25f8037bac2d";
    final String transalePwd = "nr0z6ZuzY5zK";
    final String naturalLanguageUser = "86d3549a-4097-47b7-9d36-bc6d18aaa4c7";
    final String naturalLanguagePwd = "2QBwrQGe0HMG";
    final String speachUser = "a6d36ceb-2111-46fe-b27c-be79c1796490";
    final String speachPwd = "t4giUyAqw0OR";
    final String toneUser = "862ed300-e107-40c0-977f-ec838e0c8d94";
    final String tonePwd = "ZJ6N82RbPUVL";
    final String personalUser = "c62b0b57-e482-4945-95b8-472a710c7cf5";
    final String personalPwd = "CI5fB6WjB1bv";
    final String apiVisual = "";

    /**
     * Servicio de traducción
     *
     * @param texto
     * @param idiomaOrigen
     * @param idiomaDestino
     * @return
     */
    public String translate(String texto, Language idiomaOrigen, Language idiomaDestino) {
        LanguageTranslator service = new LanguageTranslator();
        service.setUsernameAndPassword(transaleUser, transalePwd);
        TranslationResult translationResult = service.translate(
                texto, idiomaOrigen, idiomaDestino).execute();
        return translationResult.getFirstTranslation();
    }

    /**
     * analisis de lenguaje natural
     *
     * @param texto
     * @return
     */
    public AnalysisResults naturalLanguageUnderstanding(String texto) {
        NaturalLanguageUnderstanding service = new NaturalLanguageUnderstanding(
                NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27,
                naturalLanguageUser,
                naturalLanguagePwd
        );
        EntitiesOptions entities = new EntitiesOptions.Builder().sentiment(true).limit(1).build();
        //EntitiesOptions entities = new EntitiesOptions.Builder().emotion(true).limit(1).build();
        Features features = new Features.Builder().entities(entities).build();
        AnalyzeOptions parameters = new AnalyzeOptions.Builder().text(texto).features(features).build();
        AnalysisResults results = service.analyze(parameters).execute();
        return results;
    }

    /**
     * audio a texto
     *
     * @param rutaAudio
     * @return
     */
    public SpeechResults speachToText(String rutaAudio) {
        SpeechToText service = new SpeechToText();
        service.setUsernameAndPassword(speachUser, speachPwd);

        File audio = new File(rutaAudio);
        RecognizeOptions options = new RecognizeOptions.Builder()
                .contentType(HttpMediaType.AUDIO_OGG)
                .model("es-ES_BroadbandModel")
                .build();
        SpeechResults transcript = service.recognize(audio, options).execute();
        return transcript;
    }

    /**
     * analisis de matices en mensajes
     *
     * @param text
     * @return
     */
    public ToneAnalysis toneAnalyzer(String text) {
        final String VERSION_DATE = "2016-05-19";
        ToneAnalyzer service = new ToneAnalyzer(VERSION_DATE);
        service.setUsernameAndPassword(toneUser, tonePwd);
        ToneOptions toneOptions = new ToneOptions.Builder().html(text).build();
        ToneAnalysis tone = service.tone(toneOptions).execute();
        return tone;
    }

    /**
     * analisis personal
     *
     * @param texto
     * @return
     */
    public Profile personalInsights(String texto) {
        PersonalityInsights service = new PersonalityInsights("2016-10-19");
        service.setUsernameAndPassword(personalUser, personalPwd);
        ProfileOptions options = new ProfileOptions.Builder().text(texto).build();
        Profile profile = service.profile(options).execute();
        return profile;
    }

    /**
     * reconocimiento visual
     *
     * @param image
     * @return
     * @throws FileNotFoundException
     */
    public ClassifiedImages visualRecognition(String image) throws FileNotFoundException {
        VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
        service.setApiKey(apiVisual);
        ClassifyOptions options = new ClassifyOptions.Builder()
                .imagesFile(new File(image))
                .build();
        ClassifiedImages result = service.classify(options).execute();
        return result;
    }
}
