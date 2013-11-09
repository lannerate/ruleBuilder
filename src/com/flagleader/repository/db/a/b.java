package com.flagleader.repository.db.a;

import com.flagleader.database.ConnectionFactory;
import com.flagleader.database.ConnectionInfo;
import com.flagleader.database.SQLTable;
import com.flagleader.db.DBFactory;
import com.flagleader.db.Database;
import com.flagleader.repository.db.DBModel;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class b
{
  private static final String[] a = { "insert", "select", "into", "from", "as", "where", "and", "or", "on", "not", "delete", "update", "max", "min", "count", "concat", "like", "is", "null", "order", "by", "set", "distinct", "string", "int", "long", "float", "double", "date", "datatime", "HAVING", "asc", "group", "values", "inner", "join", "left", "right", "union", "desc", "in", "TRUNCATE", "DROP" };
  private static HashMap b = new HashMap();
  private List c;
  private HashMap d = new HashMap();
  private DBModel e;
  private Connection f;
  private static ArrayList g = new ArrayList(0);
  private long h = 0L;
  private String i;
  private String j;

  private b(DBModel paramDBModel)
  {
    this.e = paramDBModel;
    if ((paramDBModel.getCatalogName() != null) && (paramDBModel.getCatalogName().length() > 0))
      this.i = paramDBModel.getCatalogName();
    if ((paramDBModel.getSchemaName() != null) && (paramDBModel.getSchemaName().length() > 0))
      this.j = paramDBModel.getSchemaName();
    new c(this).start();
  }

  private synchronized void d()
  {
    if ((this.f == null) && (System.currentTimeMillis() - this.h > 60000L))
    {
      this.f = e();
      this.h = System.currentTimeMillis();
    }
  }

  private Connection e()
  {
    try
    {
      if (getClass().getClassLoader().getResource(this.e.getDatasourceName() + ".conf") != null)
        return DBFactory.newIntance().getDatabase(this.e.getDatasourceName()).getConnection();
      return ConnectionFactory.getConn(new ConnectionInfo(this.e.getDriver(), this.e.getUrl(), this.e.getUserName(), this.e.getPasswd(), this.i, this.j));
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public void a(SQLTable paramSQLTable)
  {
    this.d.put(paramSQLTable.getName().toLowerCase(), paramSQLTable.getColumnNames());
  }

  public static b a(DBModel paramDBModel)
  {
    b localb = (b)b.get(paramDBModel.getDatasourceName());
    if (localb != null)
      return localb;
    localb = new b(paramDBModel);
    b.put(paramDBModel.getDatasourceName(), localb);
    return localb;
  }

  public void a()
  {
    try
    {
      if ((this.f != null) && (!this.f.isClosed()))
      {
        this.f.close();
        this.f = null;
      }
    }
    catch (Exception localException)
    {
    }
  }

  public static void b()
  {
    Iterator localIterator = b.values().iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a();
  }

  public List c()
  {
    if (this.f == null)
      return null;
    if (this.c == null)
    {
      this.c = new ArrayList();
      ResultSet localResultSet = null;
      String[] arrayOfString = { "TABLE" };
      try
      {
        localResultSet = this.f.getMetaData().getTables(this.i, this.j, null, arrayOfString);
        for (boolean bool = localResultSet.next(); bool; bool = localResultSet.next())
        {
          String str1 = localResultSet.getString("TABLE_NAME");
          String str2 = localResultSet.getString("TABLE_TYPE");
          if ((!str2.equalsIgnoreCase("table")) || (str1.indexOf("$") != -1))
            continue;
          this.c.add(str1);
        }
      }
      catch (Exception localException)
      {
      }
    }
    return this.c;
  }

  public List a(String paramString)
  {
    if (this.f == null)
      return null;
    Object localObject = (List)this.d.get(paramString.toLowerCase());
    if (localObject == null)
    {
      localObject = new ArrayList();
      try
      {
        ResultSet localResultSet = d(paramString);
        ResultSetMetaData localResultSetMetaData = localResultSet.getMetaData();
        for (int k = 1; k <= localResultSetMetaData.getColumnCount(); k++)
          ((List)localObject).add(localResultSetMetaData.getColumnName(k));
      }
      catch (Exception localException)
      {
      }
      this.d.put(paramString.toLowerCase(), localObject);
    }
    return (List)localObject;
  }

  private ResultSet d(String paramString)
  {
    String str = "select * from " + paramString;
    Statement localStatement = null;
    ResultSet localResultSet = null;
    localStatement = this.f.createStatement();
    localStatement.setMaxRows(1);
    try
    {
      localResultSet = localStatement.executeQuery(str);
    }
    catch (Exception localException1)
    {
      try
      {
        str = "select * from " + this.j + "." + paramString;
        localResultSet = localStatement.executeQuery(str);
      }
      catch (Exception localException2)
      {
        if (this.j != null)
          str = "select * from " + this.i + "." + this.j + "." + paramString;
        else
          str = "select * from " + this.i + "." + paramString;
        localResultSet = localStatement.executeQuery(str);
      }
    }
    return localResultSet;
  }

  public static boolean b(String paramString)
  {
    paramString = paramString.replaceAll("\t", " ");
    for (paramString = paramString.replaceAll("[()]", " "); paramString.indexOf("  ") >= 0; paramString = paramString.replaceAll("  ", " "));
    paramString = paramString.trim();
    String[] arrayOfString = paramString.split(" ");
    for (int k = arrayOfString.length - 1; k >= 0; k--)
    {
      if (arrayOfString[k].endsWith(","))
      {
        if ((k >= 1) && (arrayOfString[(k - 1)].endsWith(",")))
          continue;
        if ((k >= 2) && (arrayOfString[(k - 2)].endsWith(",")))
        {
          k--;
          continue;
        }
        if (k >= 1)
        {
          if (c(arrayOfString[(k - 1)]))
            continue;
          k--;
          continue;
        }
      }
      return (arrayOfString[k].equalsIgnoreCase("from")) || (arrayOfString[k].equalsIgnoreCase("join"));
    }
    return false;
  }

  public static String a(String paramString1, String paramString2)
  {
    paramString1 = paramString1.toLowerCase();
    for (paramString1 = paramString1.replaceAll("\\s", " "); paramString1.indexOf("  ") >= 0; paramString1 = paramString1.replaceAll("  ", " "));
    for (int k = a(paramString1, 0); k >= 0; k = a(paramString1, k))
    {
      String str1 = paramString1.substring(k).trim();
      str1 = str1.replaceAll(" as ", " ");
      String[] arrayOfString = str1.split(",");
      for (int m = 0; m < arrayOfString.length; m++)
      {
        String str2 = arrayOfString[m].trim();
        int n = str2.indexOf(" ", 0);
        if (n <= 0)
          continue;
        String str3 = str2.substring(0, n);
        String str4 = str2.substring(n + 1).trim();
        if ((str4.equalsIgnoreCase(paramString2)) || (str4.startsWith(paramString2.toLowerCase() + " ")))
          return str3;
      }
    }
    return paramString2;
  }

  private static int a(String paramString, int paramInt)
  {
    if (paramString.indexOf(" from ", paramInt) >= 0)
      return paramString.indexOf(" from ", paramInt) + 6;
    if (paramString.indexOf(" join ", paramInt) >= 0)
      return paramString.indexOf(" join ", paramInt) + 6;
    if (paramString.indexOf(" into ", paramInt) >= 0)
      return paramString.indexOf(" into ", paramInt) + 6;
    if (paramString.indexOf(" update ", paramInt) >= 0)
      return paramString.indexOf(" update ", paramInt) + 8;
    return -1;
  }

  public static boolean c(String paramString)
  {
    for (int k = 0; k < a.length; k++)
      if (a[k].equalsIgnoreCase(paramString))
        return true;
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.db.a.b
 * JD-Core Version:    0.6.0
 */