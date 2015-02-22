/*
 * Silahkan digunakan dengan bebas / dimodifikasi
 * Dengan tetap mencantumkan nama @author dan Referensi / Source
 * Terima Kasih atas Kerjasamanya.
 */
package com.agung.java.hibernate;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

/**
 *
 * @author Personal
 */

@Entity     //mendeklarasikan bahwa class person adalah entity
@Table(name = "T_PERSON")   //@Table digunakan untuk meletakan definisi & konfigurasi dari tabel yang akan dimapping 
public class Person implements Serializable{
    @Id 
    //@Column mendefinisikan tabel beserta atributnya
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.AUTO)//generate id secara otomatis
    private Long id;
    
    @Column(name="nama", unique = true, length = 100)
    private String nama;
    
    @Column(name="alamat", unique = true, length=200)
    private String alamat;
    
    @Column(name="phone", unique = true,length=255)
    private String phone;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getNama(){
        return nama;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getAlamat(){
        return alamat;
    }
    
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
