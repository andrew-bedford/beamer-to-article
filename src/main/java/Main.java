import helpers.FileHelper;
import helpers.ParameterHelper;

public class Main {
    static String document;

    public static void main(String[] args) {
        ParameterHelper.parse(args);

        document = FileHelper.readStringFromFile("presentation/presentation.tex");
        changeBeamerDocumentClassToArticle();
        replaceTitleFrameWithTitle();
        removeBeamerCommands();
        convertFramesIntoParagraphs();

        if (ParameterHelper.contains("-remove-enums")) {
            removeEnumerations();
        }

        FileHelper.writeStringToFile("presentation/presentation-article.tex", document);
        System.out.println(document);
    }

    private static void removeEnumerations() {
        document = document.replace("\\begin{itemize}", "");
        document = document.replace("\\item", "");
        document = document.replace("\\end{itemize}", "");
        document = document.replace("\n\n", "\n");
    }

    private static void removeBeamerCommands() {
        document = document.replaceAll("\\\\.*beamer.*", "");
    }

    private static void replaceTitleFrameWithTitle() {
        document = document.replace("\\frame{\\titlepage}", "\\maketitle");
    }

    private static void changeBeamerDocumentClassToArticle() {
        document = document.replace("\\documentclass[notheorems]{beamer}", "\\documentclass{article}");
    }

    private static void convertFramesIntoParagraphs() {
        document = document.replace("\\begin{frame}", "");
        document = document.replaceAll("\\\\frametitle\\{(.*?)}", "\\\\paragraph{$1}");
        document = document.replace("\\end{frame}", "");
    }
}
