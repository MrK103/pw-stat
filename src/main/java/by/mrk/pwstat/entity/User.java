package by.mrk.pwstat.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    private Integer id;
    private String name;
    private String passwd;
    private String vkid;
    private String vkname;
    private String vkphoto;
    @Column(name = "Prompt")
    private String prompt;
    private String answer;
    private String truename;
    private String idnumber;
    private String email;
    private String mobilenumber;
    private String province;
    private String city;
    private String phonenumber;
    private String address;
    private String postalcode;
    private Integer gender;
    private LocalDateTime birthday;
    private LocalDateTime creatime;
    private String qq;
    private String passwd2;
    private Integer top_update;
    private Integer lkgold;
    private Integer lksilver;
    private Integer referal;
    private Integer ref_bonus;
    private String session_data;

}
