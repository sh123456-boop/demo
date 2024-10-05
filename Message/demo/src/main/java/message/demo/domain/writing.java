package message.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "WRITING")
public class writing {

    @Id
    @GeneratedValue
    @Column(name = "writing_id")
    private Long id;

    private String title;

    private String content;

    public writing() {
    }
}
