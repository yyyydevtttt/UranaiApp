package ytdvlpmnt.uranai.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * uranai_kekkaテーブル用Bean
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class UranaiKekka {

	/** 日付 */
	private String uranaiDate;
	/** やぎ座順位 */
	private int capricorn;
	/** みずがめ座順位 */
	private int aquarius;
	/** うお座順位 */
	private int pisces;
	/** おひつじ座順位 */
	private int aries;
	/** おうし座順位 */
	private int taurus;
	/** ふたご座順位 */
	private int gemini;
	/** かに座順位 */
	private int cancer;
	/** しし座順位 */
	private int leo;
	/** おとめ座順位 */
	private int virgo;
	/** てんびん座順位 */
	private int libra;
	/** さそり座順位 */
	private int scorpio;
	/** いて座順位 */
	private int sagittarius;

	/**
	 * @return uranaiDate
	 */
	public String getUranaiDate() {
		return uranaiDate;
	}
	/**
	 * @param uranaiDate セットする uranaiDate
	 */
	public void setUranaiDate(String uranaiDate) {
		this.uranaiDate = uranaiDate;
	}
	/**
	 * @return capricorn
	 */
	public int getCapricorn() {
		return capricorn;
	}
	/**
	 * @param capricorn セットする capricorn
	 */
	public void setCapricorn(int capricorn) {
		this.capricorn = capricorn;
	}
	/**
	 * @return aquarius
	 */
	public int getAquarius() {
		return aquarius;
	}
	/**
	 * @param aquarius セットする aquarius
	 */
	public void setAquarius(int aquarius) {
		this.aquarius = aquarius;
	}
	/**
	 * @return pisces
	 */
	public int getPisces() {
		return pisces;
	}
	/**
	 * @param pisces セットする pisces
	 */
	public void setPisces(int pisces) {
		this.pisces = pisces;
	}
	/**
	 * @return aries
	 */
	public int getAries() {
		return aries;
	}
	/**
	 * @param aries セットする aries
	 */
	public void setAries(int aries) {
		this.aries = aries;
	}
	/**
	 * @return taurus
	 */
	public int getTaurus() {
		return taurus;
	}
	/**
	 * @param taurus セットする taurus
	 */
	public void setTaurus(int taurus) {
		this.taurus = taurus;
	}
	/**
	 * @return gemini
	 */
	public int getGemini() {
		return gemini;
	}
	/**
	 * @param gemini セットする gemini
	 */
	public void setGemini(int gemini) {
		this.gemini = gemini;
	}
	/**
	 * @return cancer
	 */
	public int getCancer() {
		return cancer;
	}
	/**
	 * @param cancer セットする cancer
	 */
	public void setCancer(int cancer) {
		this.cancer = cancer;
	}
	/**
	 * @return leo
	 */
	public int getLeo() {
		return leo;
	}
	/**
	 * @param leo セットする leo
	 */
	public void setLeo(int leo) {
		this.leo = leo;
	}
	/**
	 * @return virgo
	 */
	public int getVirgo() {
		return virgo;
	}
	/**
	 * @param virgo セットする virgo
	 */
	public void setVirgo(int virgo) {
		this.virgo = virgo;
	}
	/**
	 * @return libra
	 */
	public int getLibra() {
		return libra;
	}
	/**
	 * @param libra セットする libra
	 */
	public void setLibra(int libra) {
		this.libra = libra;
	}
	/**
	 * @return scorpio
	 */
	public int getScorpio() {
		return scorpio;
	}
	/**
	 * @param scorpio セットする scorpio
	 */
	public void setScorpio(int scorpio) {
		this.scorpio = scorpio;
	}
	/**
	 * @return sagittarius
	 */
	public int getSagittarius() {
		return sagittarius;
	}
	/**
	 * @param sagittarius セットする sagittarius
	 */
	public void setSagittarius(int sagittarius) {
		this.sagittarius = sagittarius;
	}
}
