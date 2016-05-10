/**
 * Plain Old Java Object used to store ucas that need to be added to the database.
 * Used as a model to transfer this data to the web page.
 */

package com.softwareengineers.web.model;

/**
 *
 * @author Samuel
 */
public class UCASToAdd {
    public String[] ucas;
    public String error = null;

    public UCASToAdd(String[] ucas) {
        this.ucas = ucas;
    }

    public String[] getUcas() {
        return ucas;
    }

    public void setUcas(String[] ucas) {
        this.ucas = ucas;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
