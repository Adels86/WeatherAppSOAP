package net.atos.weatherSoap.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserOrder {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Zocca;
    private String Warsaw;
    private String London;
    private String Paris;
    private String Rome;
    @Column(name = "new_york")
    private String NewYork;
    private String Madrid;
    private String Berlin;
    private String Tokio;
    private String Sydney;
}
