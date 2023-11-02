package com.stream.user.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "ProfileImageData")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;
    private String name;
    private String type;

    @Lob
    @Column(name = "imageData")
    private byte[] imageData;
}
