package com.artique.artiqueadmin.dto.musical;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class MusicalDatas {
  private List<MusicalChart> musicals;
  private int page;
  private int totalPage;
  private int size;
}
