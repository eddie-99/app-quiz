package com.example.testautomatizado;

public class ModeloPreguntas {
    private String pregunta, res1, res2, res3, res4;
    private int preguntaCorrecta;

    public ModeloPreguntas(String pregunta, String res1, String res2, String res3, String res4, int preguntaCorrecta) {
        this.pregunta = pregunta;
        this.res1 = res1;
        this.res2 = res2;
        this.res3 = res3;
        this.res4 = res4;
        this.preguntaCorrecta = preguntaCorrecta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRes1() {
        return res1;
    }

    public void setRes1(String res1) {
        this.res1 = res1;
    }

    public String getRes2() {
        return res2;
    }

    public void setRes2(String res2) {
        this.res2 = res2;
    }

    public String getRes3() {
        return res3;
    }

    public void setRes3(String res3) {
        this.res3 = res3;
    }

    public String getRes4() {
        return res4;
    }

    public void setRes4(String res4) {
        this.res4 = res4;
    }

    public int getPreguntaCorrecta() {
        return preguntaCorrecta;
    }

    public void setPreguntaCorrecta(int preguntaCorrecta) {
        this.preguntaCorrecta = preguntaCorrecta;
    }
}
