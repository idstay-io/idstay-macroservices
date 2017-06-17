package io.idstay.prs.domain;


import javax.persistence.*;
import java.util.Locale;


@Entity
public class Crew {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="crew_id")
    private long id;
    private String crewName;
    private Locale locale;
    private boolean activate = true;

    protected Crew() {}
    public Crew(final long id) {
        this.id = id;
    }
    public Crew(final String crewName, final Locale locale, boolean activate) {
        this.crewName = crewName;
        this.locale = locale;
        this.activate = activate;
    }

    public long getId() {
        return id;
    }

    public String getCrewName() {
        return crewName;
    }

    public void setCrewId(String crewName) {
        this.crewName = crewName;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocalse(Locale locale) {
        this.locale = locale;
    }

    public boolean getActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }


}