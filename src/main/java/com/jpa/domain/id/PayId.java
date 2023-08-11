package com.jpa.domain.id;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class PayId implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="employee_id")
    private int id;

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name="date")
    private Date date;
	
	public PayId(int id, Date date) {
		this.id = id;
		this.date = date;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.date);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		} else if(this.getClass() != obj.getClass()) {
			return false;
		}
		
		PayId payId = (PayId) obj;
		boolean flag = Objects.equals(this.hashCode(), payId.hashCode());
		
		return flag;
	}
}
