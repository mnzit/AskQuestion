/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.askquestion.services;

import java.util.List;

/**
 *
 * @author Dell
 */
public interface GenericService<TMODEL, TDTO> {

    public TMODEL save(TDTO dto);

    public List<TMODEL> getAll();

    public TMODEL getById(Integer id);

    public TMODEL update(TDTO dto);

    public Boolean delete(Integer id);

}
