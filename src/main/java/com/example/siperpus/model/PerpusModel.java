package com.example.siperpus.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "ref_buku")
@NoArgsConstructor
@Where(clause = "is_deleted = false")
public class PerpusModel extends BaseDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Judul", nullable = false)
    private String Judul;

    @Column(name = "Pengarang", nullable = false)
    private String Pengarang;

    @Column(name = "Kategori", nullable = false)
    private String Kategori;

    @Column(name = "Penerbit", nullable = false)
    private String Penerbit;

    @Column(name = "Tahun", nullable = false)
    private Integer Tahun;


}
