package com.quixada.marsweather.api.dtos;

public class SolDto {
	
	private Long id;
	private String mn;
	private String mx;
	private String av;

	public SolDto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "SolDto [id=" + id + ", mx=" + mx + ", mn=" + mn + "]";
	}

	public String getMn() {
		return mn;
	}

	public void setMn(String mn) {
		this.mn = mn;
	}

	public String getMx() {
		return mx;
	}

	public void setMx(String mx) {
		this.mx = mx;
	}

	public String getAv() {
		return av;
	}

	public void setAv(String av) {
		this.av = av;
	}

}
