package com.muheda.domain;

import java.io.Serializable;

public class Msg  implements Serializable {

  private static final long serialVersionUID = 1L;

  private  String name;

    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
}
