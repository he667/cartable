package com.ybi.dm.cartable.models;

/**
 * Created by Bouddha on 21/01/2018.
 * Links go from top to bottom or at the same level
 * eg Parent -> Child, Raw -> Rich, v0 -> v1
 */
public enum LinkType {
    FOREIGN, // destination  has a relation with source
    CHILD, // destination is a child of source
    RICH // destination is a richer version of source

}
