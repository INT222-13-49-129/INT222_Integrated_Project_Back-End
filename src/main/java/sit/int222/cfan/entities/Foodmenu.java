package sit.int222.cfan.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Foodmenu {

  @Id
  @GeneratedValue
  private long foodmenuid;
  private String foodname;
  private long totalkcal;
  private String image;
  private String description;

  @Column(columnDefinition = "ENUM('PUBLISH', 'PERSONAL')")
  @Enumerated(EnumType.STRING)
  private FoodmenuStatus foodmenustatus;

  @ManyToOne
  private Foodtype foodtype;

  @JsonBackReference
  @ManyToOne
  private User user;

  @OneToMany(mappedBy = "foodmenu")
  List<FoodmenuHasIngredians> foodmenuHasIngrediansList;

  @JsonBackReference
  @OneToMany(mappedBy = "foodmenu")
  List<MealHasFoodmenu> mealHasFoodmenuList;

  public enum FoodmenuStatus {
    PUBLISH,PERSONAL
  }
}