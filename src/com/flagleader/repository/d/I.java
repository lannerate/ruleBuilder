package com.flagleader.repository.d;

import com.flagleader.engine.Property;
import com.flagleader.util.StringUtil;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DecimalFormat;

public final class I
{
  public static String a(Object paramObject)
  {
    if (paramObject == null)
      return "";
    try
    {
      if ((paramObject instanceof String))
        return (String)paramObject;
      if ((paramObject instanceof Number))
      {
        if (((paramObject instanceof Double)) || ((paramObject instanceof Float)))
        {
          if (((Number)paramObject).longValue() == ((Number)paramObject).doubleValue())
            return String.valueOf(((Number)paramObject).longValue());
          if ((paramObject instanceof Double))
            return StringUtil.formatDouble(Double.valueOf(((Number)paramObject).doubleValue()));
          if ((paramObject instanceof Float))
            return new DecimalFormat().format(((Number)paramObject).floatValue());
        }
        return paramObject.toString();
      }
      if ((paramObject instanceof byte[]))
        return "@bytes";
      if ((paramObject instanceof Blob))
        return new String(((Blob)paramObject).getBytes(1L, (int)((Blob)paramObject).length()));
      if ((paramObject instanceof Clob))
        return ((Clob)paramObject).getSubString(1L, (int)((Clob)paramObject).length());
      if ((paramObject instanceof java.sql.Date))
        return Property.getInstance().formatDate((java.sql.Date)paramObject);
      if ((paramObject instanceof Time))
        return Property.getInstance().formatTime((Time)paramObject);
      if (((paramObject instanceof Timestamp)) || ((paramObject instanceof java.util.Date)))
        return Property.getInstance().formatDatetime((java.util.Date)paramObject);
    }
    catch (SQLException localSQLException)
    {
      return "";
    }
    return paramObject.toString();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.d.I
 * JD-Core Version:    0.6.0
 */