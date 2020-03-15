package com.quixada.marsweather.api.dtos;

public class SolDto {
	
	private Long id;
	private float mn;
	private float mx;
	private float av;

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

	public float getMn() {
		return mn;
	}

	public void setMn(float mn) {
		this.mn = mn;
	}

	public float getMx() {
		return mx;
	}

	public void setMx(float mx) {
		this.mx = mx;
	}

	public float getAv() {
		return av;
	}

	public void setAv(float av) {
		this.av = av;
	}

}
