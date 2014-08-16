package com.example.dilip.fuelefficiency;

/**
 * Created by Dilip on 8/3/2014.
 */
public class Fuel {
    private String _dtFuelledDate;
    private String _sOdoReading;
    private String _sPricePerGa;

    private String _sTotalFuel;

    public Fuel(String dtFuelledDate, String sOdoReading, String sPricePerGa, String sTotalFuel) {
        _dtFuelledDate = dtFuelledDate;
        _sOdoReading = sOdoReading;
        _sPricePerGa = sPricePerGa;
        _sTotalFuel = sTotalFuel;
    }

    public void set_dtFuelledDate(String _dtFuelledDate) {
        this._dtFuelledDate = _dtFuelledDate;
    }

    public void set_sOdoReading(String _sOdoReading) {
        this._sOdoReading = _sOdoReading;
    }

    public void set_sPricePerGa(String _sPricePerGa) {
        this._sPricePerGa = _sPricePerGa;
    }

    public void set_sTotalFuel(String _sTotalFuel) {
        this._sTotalFuel = _sTotalFuel;
    }

    public String get_sTotalFuel() {
        return _sTotalFuel;
    }

    public String get_dtFuelledDate() {
        return _dtFuelledDate;
    }

    public String get_sOdoReading() {
        return _sOdoReading;
    }

    public String get_sPricePerGa() {
        return _sPricePerGa;
    }

}
