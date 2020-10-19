package com.sparta.eng68.traineetracker.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "week_report", schema = "training_tracker")
public class WeekReport {
    private Integer reportId;
    private Integer traineeId;
    private Integer weekNum;
    private LocalDateTime deadline;
    private String consultantGradeTrainee;
    private String technicalGradeTrainee;
    private String startTrainee;
    private String stopTrainee;
    private String continueTrainee;
    private String consultantGradeTrainer;
    private String technicalGradeTrainer;
    private String overallGradeTrainer;
    private String trainerComments;
    private String startTrainer;
    private String stopTrainer;
    private String continueTrainer;
    private LocalDateTime mostRecentEdit;
    private Byte traineeStartFlag;
    private Byte traineeStopFlag;
    private Byte traineeContinueFlag;
    private Byte traineeConsultantGradeFlag;
    private Byte traineeTechnicalGradeFlag;
    private Byte trainerCommentsFlag;
    private Byte trainerStartFlag;
    private Byte trainerStopFlag;
    private Byte trainerContinueFlag;
    private Byte trainerConsultantGradeFlag;
    private Byte trainerTechnicalGradeFlag;
    private Byte trainerOverallGradeFlag;

    @Id
    @Column(name = "report_id")
    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    @Basic
    @Column(name = "trainee_id")
    public Integer getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(Integer traineeId) {
        this.traineeId = traineeId;
    }

    @Basic
    @Column(name = "week_num")
    public Integer getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(Integer weekNum) {
        this.weekNum = weekNum;
    }

    @Basic
    @Column(name = "deadline")
    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    @Basic
    @Column(name = "consultant_grade_trainee")
    public String getConsultantGradeTrainee() {
        return consultantGradeTrainee;
    }

    public void setConsultantGradeTrainee(String consultantGradeTrainee) {
        this.consultantGradeTrainee = consultantGradeTrainee;
    }

    @Basic
    @Column(name = "technical_grade_trainee")
    public String getTechnicalGradeTrainee() {
        return technicalGradeTrainee;
    }

    public void setTechnicalGradeTrainee(String technicalGradeTrainee) {
        this.technicalGradeTrainee = technicalGradeTrainee;
    }

    @Basic
    @Column(name = "start_trainee")
    public String getStartTrainee() {
        return startTrainee;
    }

    public void setStartTrainee(String startTrainee) {
        this.startTrainee = startTrainee;
    }

    @Basic
    @Column(name = "stop_trainee")
    public String getStopTrainee() {
        return stopTrainee;
    }

    public void setStopTrainee(String stopTrainee) {
        this.stopTrainee = stopTrainee;
    }

    @Basic
    @Column(name = "continue_trainee")
    public String getContinueTrainee() {
        return continueTrainee;
    }

    public void setContinueTrainee(String continueTrainee) {
        this.continueTrainee = continueTrainee;
    }

    @Basic
    @Column(name = "consultant_grade_trainer")
    public String getConsultantGradeTrainer() {
        return consultantGradeTrainer;
    }

    public void setConsultantGradeTrainer(String consultantGradeTrainer) {
        this.consultantGradeTrainer = consultantGradeTrainer;
    }

    @Basic
    @Column(name = "technical_grade_trainer")
    public String getTechnicalGradeTrainer() {
        return technicalGradeTrainer;
    }

    public void setTechnicalGradeTrainer(String technicalGradeTrainer) {
        this.technicalGradeTrainer = technicalGradeTrainer;
    }

    @Basic
    @Column(name = "overall_grade_trainer")
    public String getOverallGradeTrainer() {
        return overallGradeTrainer;
    }

    public void setOverallGradeTrainer(String overallGradeTrainer) {
        this.overallGradeTrainer = overallGradeTrainer;
    }

    @Basic
    @Column(name = "trainer_comments")
    public String getTrainerComments() {
        return trainerComments;
    }

    public void setTrainerComments(String trainerComments) {
        this.trainerComments = trainerComments;
    }

    @Basic
    @Column(name = "start_trainer")
    public String getStartTrainer() {
        return startTrainer;
    }

    public void setStartTrainer(String startTrainer) {
        this.startTrainer = startTrainer;
    }

    @Basic
    @Column(name = "stop_trainer")
    public String getStopTrainer() {
        return stopTrainer;
    }

    public void setStopTrainer(String stopTrainer) {
        this.stopTrainer = stopTrainer;
    }

    @Basic
    @Column(name = "continue_trainer")
    public String getContinueTrainer() {
        return continueTrainer;
    }

    public void setContinueTrainer(String continueTrainer) {
        this.continueTrainer = continueTrainer;
    }

    @Basic
    @Column(name = "most_recent_edit")
    public LocalDateTime getMostRecentEdit() {
        return mostRecentEdit;
    }

    public void setMostRecentEdit(LocalDateTime mostRecentEdit) {
        this.mostRecentEdit = mostRecentEdit;
    }

    @Basic
    @Column(name = "trainee_start_flag")
    public Byte getTraineeStartFlag() {
        return traineeStartFlag;
    }

    public void setTraineeStartFlag(Byte traineeStartFlag) {
        this.traineeStartFlag = traineeStartFlag;
    }

    @Basic
    @Column(name = "trainee_stop_flag")
    public Byte getTraineeStopFlag() {
        return traineeStopFlag;
    }

    public void setTraineeStopFlag(Byte traineeStopFlag) {
        this.traineeStopFlag = traineeStopFlag;
    }

    @Basic
    @Column(name = "trainee_continue_flag")
    public Byte getTraineeContinueFlag() {
        return traineeContinueFlag;
    }

    public void setTraineeContinueFlag(Byte traineeContinueFlag) {
        this.traineeContinueFlag = traineeContinueFlag;
    }

    @Basic
    @Column(name = "trainee_consultant_grade_flag")
    public Byte getTraineeConsultantGradeFlag() {
        return traineeConsultantGradeFlag;
    }

    public void setTraineeConsultantGradeFlag(Byte traineeConsultantGradeFlag) {
        this.traineeConsultantGradeFlag = traineeConsultantGradeFlag;
    }

    @Basic
    @Column(name = "trainee_technical_grade_flag")
    public Byte getTraineeTechnicalGradeFlag() {
        return traineeTechnicalGradeFlag;
    }

    public void setTraineeTechnicalGradeFlag(Byte traineeTechnicalGradeFlag) {
        this.traineeTechnicalGradeFlag = traineeTechnicalGradeFlag;
    }

    @Basic
    @Column(name = "trainer_comments_flag")
    public Byte getTrainerCommentsFlag() {
        return trainerCommentsFlag;
    }

    public void setTrainerCommentsFlag(Byte trainerCommentsFlag) {
        this.trainerCommentsFlag = trainerCommentsFlag;
    }

    @Basic
    @Column(name = "trainer_start_flag")
    public Byte getTrainerStartFlag() {
        return trainerStartFlag;
    }

    public void setTrainerStartFlag(Byte trainerStartFlag) {
        this.trainerStartFlag = trainerStartFlag;
    }

    @Basic
    @Column(name = "trainer_stop_flag")
    public Byte getTrainerStopFlag() {
        return trainerStopFlag;
    }

    public void setTrainerStopFlag(Byte trainerStopFlag) {
        this.trainerStopFlag = trainerStopFlag;
    }

    @Basic
    @Column(name = "trainer_continue_flag")
    public Byte getTrainerContinueFlag() {
        return trainerContinueFlag;
    }

    public void setTrainerContinueFlag(Byte trainerContinueFlag) {
        this.trainerContinueFlag = trainerContinueFlag;
    }

    @Basic
    @Column(name = "trainer_consultant_grade_flag")
    public Byte getTrainerConsultantGradeFlag() {
        return trainerConsultantGradeFlag;
    }

    public void setTrainerConsultantGradeFlag(Byte trainerConsultantGradeFlag) {
        this.trainerConsultantGradeFlag = trainerConsultantGradeFlag;
    }

    @Basic
    @Column(name = "trainer_technical_grade_flag")
    public Byte getTrainerTechnicalGradeFlag() {
        return trainerTechnicalGradeFlag;
    }

    public void setTrainerTechnicalGradeFlag(Byte trainerTechnicalGradeFlag) {
        this.trainerTechnicalGradeFlag = trainerTechnicalGradeFlag;
    }

    @Basic
    @Column(name = "trainer_overall_grade_flag")
    public Byte getTrainerOverallGradeFlag() {
        return trainerOverallGradeFlag;
    }

    public void setTrainerOverallGradeFlag(Byte trainerOverallGradeFlag) {
        this.trainerOverallGradeFlag = trainerOverallGradeFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeekReport that = (WeekReport) o;

        if (reportId != null ? !reportId.equals(that.reportId) : that.reportId != null) return false;
        if (traineeId != null ? !traineeId.equals(that.traineeId) : that.traineeId != null) return false;
        if (weekNum != null ? !weekNum.equals(that.weekNum) : that.weekNum != null) return false;
        if (deadline != null ? !deadline.equals(that.deadline) : that.deadline != null) return false;
        if (consultantGradeTrainee != null ? !consultantGradeTrainee.equals(that.consultantGradeTrainee) : that.consultantGradeTrainee != null)
            return false;
        if (technicalGradeTrainee != null ? !technicalGradeTrainee.equals(that.technicalGradeTrainee) : that.technicalGradeTrainee != null)
            return false;
        if (startTrainee != null ? !startTrainee.equals(that.startTrainee) : that.startTrainee != null) return false;
        if (stopTrainee != null ? !stopTrainee.equals(that.stopTrainee) : that.stopTrainee != null) return false;
        if (continueTrainee != null ? !continueTrainee.equals(that.continueTrainee) : that.continueTrainee != null)
            return false;
        if (consultantGradeTrainer != null ? !consultantGradeTrainer.equals(that.consultantGradeTrainer) : that.consultantGradeTrainer != null)
            return false;
        if (technicalGradeTrainer != null ? !technicalGradeTrainer.equals(that.technicalGradeTrainer) : that.technicalGradeTrainer != null)
            return false;
        if (overallGradeTrainer != null ? !overallGradeTrainer.equals(that.overallGradeTrainer) : that.overallGradeTrainer != null)
            return false;
        if (trainerComments != null ? !trainerComments.equals(that.trainerComments) : that.trainerComments != null)
            return false;
        if (startTrainer != null ? !startTrainer.equals(that.startTrainer) : that.startTrainer != null) return false;
        if (stopTrainer != null ? !stopTrainer.equals(that.stopTrainer) : that.stopTrainer != null) return false;
        if (continueTrainer != null ? !continueTrainer.equals(that.continueTrainer) : that.continueTrainer != null)
            return false;
        if (mostRecentEdit != null ? !mostRecentEdit.equals(that.mostRecentEdit) : that.mostRecentEdit != null)
            return false;
        if (traineeStartFlag != null ? !traineeStartFlag.equals(that.traineeStartFlag) : that.traineeStartFlag != null)
            return false;
        if (traineeStopFlag != null ? !traineeStopFlag.equals(that.traineeStopFlag) : that.traineeStopFlag != null)
            return false;
        if (traineeContinueFlag != null ? !traineeContinueFlag.equals(that.traineeContinueFlag) : that.traineeContinueFlag != null)
            return false;
        if (traineeConsultantGradeFlag != null ? !traineeConsultantGradeFlag.equals(that.traineeConsultantGradeFlag) : that.traineeConsultantGradeFlag != null)
            return false;
        if (traineeTechnicalGradeFlag != null ? !traineeTechnicalGradeFlag.equals(that.traineeTechnicalGradeFlag) : that.traineeTechnicalGradeFlag != null)
            return false;
        if (trainerCommentsFlag != null ? !trainerCommentsFlag.equals(that.trainerCommentsFlag) : that.trainerCommentsFlag != null)
            return false;
        if (trainerStartFlag != null ? !trainerStartFlag.equals(that.trainerStartFlag) : that.trainerStartFlag != null)
            return false;
        if (trainerStopFlag != null ? !trainerStopFlag.equals(that.trainerStopFlag) : that.trainerStopFlag != null)
            return false;
        if (trainerContinueFlag != null ? !trainerContinueFlag.equals(that.trainerContinueFlag) : that.trainerContinueFlag != null)
            return false;
        if (trainerConsultantGradeFlag != null ? !trainerConsultantGradeFlag.equals(that.trainerConsultantGradeFlag) : that.trainerConsultantGradeFlag != null)
            return false;
        if (trainerTechnicalGradeFlag != null ? !trainerTechnicalGradeFlag.equals(that.trainerTechnicalGradeFlag) : that.trainerTechnicalGradeFlag != null)
            return false;
        if (trainerOverallGradeFlag != null ? !trainerOverallGradeFlag.equals(that.trainerOverallGradeFlag) : that.trainerOverallGradeFlag != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reportId != null ? reportId.hashCode() : 0;
        result = 31 * result + (traineeId != null ? traineeId.hashCode() : 0);
        result = 31 * result + (weekNum != null ? weekNum.hashCode() : 0);
        result = 31 * result + (deadline != null ? deadline.hashCode() : 0);
        result = 31 * result + (consultantGradeTrainee != null ? consultantGradeTrainee.hashCode() : 0);
        result = 31 * result + (technicalGradeTrainee != null ? technicalGradeTrainee.hashCode() : 0);
        result = 31 * result + (startTrainee != null ? startTrainee.hashCode() : 0);
        result = 31 * result + (stopTrainee != null ? stopTrainee.hashCode() : 0);
        result = 31 * result + (continueTrainee != null ? continueTrainee.hashCode() : 0);
        result = 31 * result + (consultantGradeTrainer != null ? consultantGradeTrainer.hashCode() : 0);
        result = 31 * result + (technicalGradeTrainer != null ? technicalGradeTrainer.hashCode() : 0);
        result = 31 * result + (overallGradeTrainer != null ? overallGradeTrainer.hashCode() : 0);
        result = 31 * result + (trainerComments != null ? trainerComments.hashCode() : 0);
        result = 31 * result + (startTrainer != null ? startTrainer.hashCode() : 0);
        result = 31 * result + (stopTrainer != null ? stopTrainer.hashCode() : 0);
        result = 31 * result + (continueTrainer != null ? continueTrainer.hashCode() : 0);
        result = 31 * result + (mostRecentEdit != null ? mostRecentEdit.hashCode() : 0);
        result = 31 * result + (traineeStartFlag != null ? traineeStartFlag.hashCode() : 0);
        result = 31 * result + (traineeStopFlag != null ? traineeStopFlag.hashCode() : 0);
        result = 31 * result + (traineeContinueFlag != null ? traineeContinueFlag.hashCode() : 0);
        result = 31 * result + (traineeConsultantGradeFlag != null ? traineeConsultantGradeFlag.hashCode() : 0);
        result = 31 * result + (traineeTechnicalGradeFlag != null ? traineeTechnicalGradeFlag.hashCode() : 0);
        result = 31 * result + (trainerCommentsFlag != null ? trainerCommentsFlag.hashCode() : 0);
        result = 31 * result + (trainerStartFlag != null ? trainerStartFlag.hashCode() : 0);
        result = 31 * result + (trainerStopFlag != null ? trainerStopFlag.hashCode() : 0);
        result = 31 * result + (trainerContinueFlag != null ? trainerContinueFlag.hashCode() : 0);
        result = 31 * result + (trainerConsultantGradeFlag != null ? trainerConsultantGradeFlag.hashCode() : 0);
        result = 31 * result + (trainerTechnicalGradeFlag != null ? trainerTechnicalGradeFlag.hashCode() : 0);
        result = 31 * result + (trainerOverallGradeFlag != null ? trainerOverallGradeFlag.hashCode() : 0);
        return result;
    }
}
