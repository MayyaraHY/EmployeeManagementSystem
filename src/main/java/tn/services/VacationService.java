package tn.services;

import tn.interfaces.InterfaceCRUD;
import tn.models.Vacation;
import tn.util.Connexion;

import java.sql.Connection;

public class VacationService implements InterfaceCRUD<Vacation> {
    Connection cnx = Connexion.getInstance().getCnx();

    @Override
    public void add(Vacation vacation) {

    }

    @Override
    public void update(Vacation vacation) {

    }

    @Override
    public void remove(int id) {

    }
}
