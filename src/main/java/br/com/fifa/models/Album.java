package br.com.fifa.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// * ---------------------------------------------------------------------- * //

@Entity
@Table(name = "albums")
public class Album 
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 100)
  private String name;

  @Column(name = "host_country", nullable = false, length = 100)
  private String hostCountry;

  @Column(nullable = false)
  private int year;

  @Column(nullable = false, length = 10)
  private String cover;

  @Column(nullable = false)
  private List<String> countries;

  @Column(nullable = true)
  private int cromos;

  @Column(name = "special_cromos", nullable = true)
  private int specialCromos;

  @Column(name = "extra_cromos", nullable = true)
  private int extraCromos;

  // *** --- constructors ----------------------------------------------- *** //

  public Album() {}

  public Album(String name, String hostCountry, int year, String cover, 
    List<String> countries) 
  {
    this.name = name;
    this.hostCountry = hostCountry;
    this.year = year;
    this.cover = cover;
    this.countries = countries;
  }

  // *** --- overrides -------------------------------------------------- *** //

  @Override
  public String toString() 
  {
    String countries = "";

    for (String string : this.countries) 
    {
      countries += string + ", ";
    }

    String album = "Album:\n"
    + "\tid: " + id + "\n"
    + "\tname: " + name + "\n"
    + "\thostCountry: " + hostCountry + "\n"
    + "\tyear: " + year + "\n"
    + "\tcover: " + cover + "\n"
    + "\tcountries: " + countries + "\n"
    + "\tcromos: " + cromos + "\n"
    + "\tspecialCromos: " + specialCromos + "\n"
    + "\textraCromos: " + extraCromos + "\n";

    return album;
  }

  // *** --- getters and setters ---------------------------------------- *** //

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  // ------------------------------------------------------------------------ //

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    if (name == null || name.length() < 10)
      throw new IllegalArgumentException("Name must be at least 10 characters long");

    this.name = name;
  }

  // ------------------------------------------------------------------------ //

  public String getHostCountry()
  {
    return hostCountry;
  }

  public void setHostCountry(String hostCountry)
  {
    if (hostCountry == null || hostCountry.length() < 3)
      throw new IllegalArgumentException("Host country must be at least 3 characters long");
    
    this.hostCountry = hostCountry;
  }

  // ------------------------------------------------------------------------ //

  public String getCover()
  {
    return cover;
  }

  public void setCover(String cover)
  {
    if (cover == null || cover.length() < 4)
      throw new IllegalArgumentException("Cover must be at least 4 characters long");

    this.cover = cover;
  }

  // ------------------------------------------------------------------------ //

  public int getYear()
  {
    return year;
  }

  public void setYear(int year)
  {
    this.year = year;
  }

  // ------------------------------------------------------------------------ //

  public List<String> getCountries()
  {
    return countries;
  }

  public void setCountries(List<String> countries)
  {
    this.countries = countries;
  }

  // ------------------------------------------------------------------------ //

  public int getCromos()
  {
    return cromos;
  }

  public void setCromos(int cromos)
  {
    this.cromos = cromos;
  }

  // ------------------------------------------------------------------------ //

  public int getSpecialCromos()
  {
    return specialCromos;
  }

  public void setSpecialCromos(int specialCromos)
  {
    this.specialCromos = specialCromos;
  }

  // ------------------------------------------------------------------------ //
    
  public int getExtraCromos()
  {
    return extraCromos;
  }

  public void setExtraCromos(int extraCromos)
  {
    this.extraCromos = extraCromos;
  }

  // *** --- lists ------------------------------------------------------ *** //

  public void addCountry(String country)
  {
    if (country == null || country.length() < 3)
      throw new IllegalArgumentException("Country must be at least 3 characters long");

    if (country.length() > 100)
      throw new IllegalArgumentException("Country must be at most 100 characters long");
        
    this.countries.add(country);
  }
}
