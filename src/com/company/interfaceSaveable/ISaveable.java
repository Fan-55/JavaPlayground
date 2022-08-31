package com.company.interfaceSaveable;

import java.util.List;

public interface ISaveable {
    List<String> write();
    void read(List<String> readValues);
}
