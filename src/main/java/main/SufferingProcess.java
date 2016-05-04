package main;

import main.Sinners.Sinner;

import java.util.Date;

/**
 * Created by tieorange on 21/04/16.
 */
public class SufferingProcess {
    private Date startDate;
    private Date finishDate;
    private TortureDepartment tortureDepartment;
    private Sinner sinner;

    public SufferingProcess(Date startDate, Date finishDate, TortureDepartment tortureDepartment, Sinner sinner) {
        setStartDate(startDate);
        setFinishDate(finishDate);
        setTortureDepartment(tortureDepartment);
        setSinner(sinner);
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        if (startDate == null) {
            throw new IllegalArgumentException("startDate is null");
        } else {
            this.startDate = startDate;
        }
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        if (finishDate == null) {
            throw new IllegalArgumentException("finishDate is null");
        } else {
            this.finishDate = finishDate;
        }
    }

    public void setTortureDepartment(TortureDepartment tortureDepartment) {
        if (tortureDepartment == null) {
            throw new IllegalArgumentException("tortureDepartment is NULL");
        } else {
            this.tortureDepartment = tortureDepartment;
            this.tortureDepartment.addSufferingProcess(this);
        }
    }

    public TortureDepartment getTortureDepartment() {
        return tortureDepartment;
    }

    public Sinner getSinner() {
        return sinner;
    }

    public void setSinner(Sinner sinner) {
        if (sinner == null) {
            throw new IllegalArgumentException("main.Sinners.Sinner is null");
        } else {
            this.sinner = sinner;
            this.sinner.setSufferingProcess(this);
        }
    }


}
