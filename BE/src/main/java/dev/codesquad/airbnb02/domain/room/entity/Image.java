package dev.codesquad.airbnb02.domain.room.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@ToString(exclude = "room")
public class Image {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String imageUrl;

  @JsonIgnore
  @NotNull
  @ManyToOne
  @JoinColumn(foreignKey = @ForeignKey(name = "room_id"))
  private Room room;

  public Image() {}
}
