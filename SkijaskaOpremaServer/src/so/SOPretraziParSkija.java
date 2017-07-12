/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObject;
import domen.ParSkija;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nadja
 */
public class SOPretraziParSkija extends AbstractSo{

    private String pretraga;
    private List<AbstractObject> filterLista;
    @Override
    protected void izvrsiKonkretnuOperaciju() throws Exception {
        SOUcitajListuParovaSkija sou = new SOUcitajListuParovaSkija();
        sou.izvrsiOperaciju();
        List<AbstractObject> izBaze = sou.getListaParova();
        filterLista = new ArrayList<>();
        pretraga = pretraga.toLowerCase();
        for (AbstractObject abstractObjekat : izBaze) {
            ParSkija ps = (ParSkija) abstractObjekat;
            if (ps.getMarka().toLowerCase().contains(pretraga)
                    || ps.getVezovi().toLowerCase().contains(pretraga)
                    || ps.getTipSkija().getNazivTipa().toLowerCase().contains(pretraga)) {
                filterLista.add(ps);
            }
        }
    }

    public String getPretraga() {
        return pretraga;
    }

    public void setPretraga(String pretraga) {
        this.pretraga = pretraga;
    }

    public List<AbstractObject> getFilterLista() {
        return filterLista;
    }

    public void setFilterLista(List<AbstractObject> filterLista) {
        this.filterLista = filterLista;
    }
    
    
}
