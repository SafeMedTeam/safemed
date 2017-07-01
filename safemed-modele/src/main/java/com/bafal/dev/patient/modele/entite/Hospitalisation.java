package com.bafal.dev.patient.modele.entite;


public class Hospitalisation {

    /**
     * @Id
     * @GeneratedValue(strategy = GenerationType.IDENTITY)
     * @Column(name = "ID_HOSPITALISATION", unique = true, nullable = false) private Long
     *              id;
     * @Column(name = "OBSERVATIONS", length = 500) private String observations;
     * @Column(name = "DATE_DEBUT_HOSPIS")
     * @Temporal(TemporalType.DATE)
     * @DateTimeFormat(pattern = "dd/MM/yyyy") private Date dateDebutHospitalisation;
     * @Column(name = "DATE_FIN_HOSPIS")
     * @Temporal(TemporalType.DATE)
     * @DateTimeFormat(pattern = "dd/MM/yyyy") private Date dateFinHospitalisation;
     * @Column(name = "ID_PATIENT", insertable = false, updatable = false) private Long
     *              idPatient;
     * @Column(name = "ID_CHAMBRE", insertable = false, updatable = false) private Long
     *              idChambre;
     * @Override public Long getId() { return id; }
     * 
     *           public String getObservations() { return observations; }
     * 
     *           public void setObservations(String observations) { this.observations =
     *           observations; }
     * 
     *           public Date getDateDebutHospitalisation() { return
     *           dateDebutHospitalisation; }
     * 
     *           public void setDateDebutHospitalisation(Date dateDebutHospitalisation) {
     *           this.dateDebutHospitalisation = dateDebutHospitalisation; }
     * 
     *           public Date getDateFinHospitalisation() { return dateFinHospitalisation;
     *           }
     * 
     *           public void setDateFinHospitalisation(Date dateFinHospitalisation) {
     *           this.dateFinHospitalisation = dateFinHospitalisation; }
     * 
     *           public Long getIdPatient() { return idPatient; }
     * 
     *           public void setIdPatient(Long idPatient) { this.idPatient = idPatient; }
     * 
     *           public Long getIdChambre() { return idChambre; }
     * 
     *           public void setIdChambre(Long idChambre) { this.idChambre = idChambre; }
     * 
     *           public void setId(Long id) { this.id = id; }
     */

}
