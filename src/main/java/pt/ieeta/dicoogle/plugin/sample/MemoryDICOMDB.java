/**
 * Copyright (C) 2014  Universidade de Aveiro, DETI/IEETA, Bioinformatics Group - http://bioinformatics.ua.pt/
 *
 * This file is part of Dicoogle/dicoogle-plugin-sample.
 *
 * Dicoogle/dicoogle-plugin-sample is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Dicoogle/dicoogle-plugin-sample is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Dicoogle.  If not, see <http://www.gnu.org/licenses/>.
 */
package pt.ieeta.dicoogle.plugin.sample;

import java.util.ArrayList;
import java.util.List;

/**
 * An in-memory DICOM storage.
 *
 * @author Luís A. Bastião Silva <bastiao@ua.pt>
 * @author Eduardo Pinho <eduardopinho@ua.pt>
 * @author Rui Lebre - <ruilebre@ua.pt>
 */
public class MemoryDICOMDB {

    private final List<String> patientNames;
    private final List<String> studies;
    private final List<String> series;
    private final List<String> sopInstanceUIDs;

    public MemoryDICOMDB() {
        patientNames = new ArrayList<>();
        studies = new ArrayList<>();
        series = new ArrayList<>();
        sopInstanceUIDs = new ArrayList<>();
    }

    public void add(String patient, String study, String serie, String sop) {
        patientNames.add(patient);
        studies.add(study);
        series.add(serie);
        sopInstanceUIDs.add(sop);
    }

    public void remove(String sop) {
        sopInstanceUIDs.remove(sop);
    }


}
