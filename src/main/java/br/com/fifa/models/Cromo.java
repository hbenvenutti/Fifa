package br.com.fifa.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

// * ---------------------------------------------------------------------- * //

@Entity
@Table(name = "cromos")
public class Cromo
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "is_extra", nullable = false)
  private boolean isExtra;

  @Column(name = "is_rare", nullable = false)
  private boolean isRare;

  @Column(nullable = false, length = 10)
  private String version;

  @Column(nullable = false, length = 100)
  private String name;

  @Column(nullable = false)
  @Temporal(TemporalType.DATE)
  private LocalDate birthday;

  @Column(nullable = true, length = 3)
  private String country;

  @Column(nullable = true, length = 3)
  private String position;

  @Column(name = "summoning_year", nullable = true)
  private int summoningYear;

  @Column(nullable = true)
  private int height;

  @Column(nullable = true)
  private int weight;
  
  // *** --- constructors ----------------------------------------------- *** //

  public Cromo() {}

  public Cromo(boolean isExtra, boolean isRare, String version, String name)
  {
    this.isExtra = isExtra;
    this.isRare = isRare;
    this.version = version;
    this.name = name;
  }

  // *** --- getters and setters ---------------------------------------- *** //
}
