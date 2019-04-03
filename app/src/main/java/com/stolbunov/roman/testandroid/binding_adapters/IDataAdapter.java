package com.stolbunov.roman.testandroid.binding_adapters;

import java.util.List;

public interface IDataAdapter {

    <T> void setData(List<T> data);
}
