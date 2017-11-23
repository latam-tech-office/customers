@XmlJavaTypeAdapters({
   @XmlJavaTypeAdapter(value=ObjectIdAdapter.class,type=ObjectId.class)
})
package com.latam.techoffice.testdrive.model;

import com.latam.techoffice.testdrive.model.adapter.ObjectIdAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import org.bson.types.ObjectId;

