package com.info.genclikvesporform;

public class Formlar {

    private int form_id;
    private String form_ad;
    private String form_pdf_ad;


    public Formlar() {
    }

    public Formlar(int form_id, String form_ad, String form_pdf_ad) {
        this.form_id = form_id;
        this.form_ad = form_ad;
        this.form_pdf_ad = form_pdf_ad;
    }

    public int getForm_id() {
        return form_id;
    }

    public void setForm_id(int form_id) {
        this.form_id = form_id;
    }

    public String getForm_ad() {
        return form_ad;
    }

    public void setForm_ad(String form_ad) {
        this.form_ad = form_ad;
    }

    public String getForm_pdf_ad() {
        return form_pdf_ad;
    }

    public void setForm_pdf_ad(String form_pdf_ad) {
        this.form_pdf_ad = form_pdf_ad;
    }
}
