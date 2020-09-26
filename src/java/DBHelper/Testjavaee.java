/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBHelper;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SHERIFF
 */
@Entity
@Table(name = "testjavaee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Testjavaee.findAll", query = "SELECT t FROM Testjavaee t")
    , @NamedQuery(name = "Testjavaee.findById", query = "SELECT t FROM Testjavaee t WHERE t.id = :id")
    , @NamedQuery(name = "Testjavaee.findByPlayerRank", query = "SELECT t FROM Testjavaee t WHERE t.playerRank = :playerRank")
    , @NamedQuery(name = "Testjavaee.findByPlayerTeam", query = "SELECT t FROM Testjavaee t WHERE t.playerTeam = :playerTeam")
    , @NamedQuery(name = "Testjavaee.findByPlayerName", query = "SELECT t FROM Testjavaee t WHERE t.playerName = :playerName")})
public class Testjavaee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "playerRank")
    private String playerRank;
    @Basic(optional = false)
    @Column(name = "playerTeam")
    private String playerTeam;
    @Basic(optional = false)
    @Column(name = "playerName")
    private String playerName;

    public Testjavaee() {
    }

    public Testjavaee(Integer id) {
        this.id = id;
    }

    public Testjavaee( String playerRank, String playerTeam, String playerName) {
        this.playerRank = playerRank;
        this.playerTeam = playerTeam;
        this.playerName = playerName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlayerRank() {
        return playerRank;
    }

    public void setPlayerRank(String playerRank) {
        this.playerRank = playerRank;
    }

    public String getPlayerTeam() {
        return playerTeam;
    }

    public void setPlayerTeam(String playerTeam) {
        this.playerTeam = playerTeam;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Testjavaee)) {
            return false;
        }
        Testjavaee other = (Testjavaee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBHelper.Testjavaee[ id=" + id + " ]";
    }
    
}
