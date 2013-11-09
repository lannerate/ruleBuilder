package com.flagleader.repository.db;

import com.flagleader.database.ConnectionFactory;
import com.flagleader.database.ConnectionInfo;
import com.flagleader.database.QueryUtil;
import com.flagleader.database.SQLProcedure;
import com.flagleader.database.SQLTable;
import com.flagleader.database.SchemaUtil;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.d;
import com.flagleader.repository.db.a.b;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.n;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.MethodParam;
import com.flagleader.repository.tree.AbstractBOContainer;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.sql.DBConfig;
import com.flagleader.util.StringUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class DBModel extends AbstractBOContainer
  implements IBusinessObjectContainer, IBusinessObject
{
  public static final String NAME = "DBModel";
  private String url = "";
  private String driver = "";
  private String userName = "";
  private String encryptedPasswd = "";
  private String datasourceName = "";
  private String catalogName = "";
  private String schemaName = "";
  private String dbFilePath = "";
  private int connType = 0;
  public static final int COMMIT = 0;
  public static final int AUTOCOMMIT = 1;
  public static final int NOCOMMIT = 2;
  public static final int AFTERCOMMIT = 3;
  private SchemaUtil schema = null;
  private int transationlevel = 0;
  private String varName = "";

  public DBModel(DBModel paramDBModel)
  {
    super(paramDBModel);
    this.url = paramDBModel.url;
    this.driver = paramDBModel.driver;
    this.userName = paramDBModel.userName;
    this.encryptedPasswd = paramDBModel.encryptedPasswd;
    this.dbFilePath = paramDBModel.dbFilePath;
    this.datasourceName = paramDBModel.datasourceName;
    this.catalogName = paramDBModel.catalogName;
    this.schemaName = paramDBModel.schemaName;
    this.connType = paramDBModel.connType;
    this.varName = paramDBModel.varName;
  }

  public DBModel(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this.url = paramString2;
    this.driver = paramString1;
    this.userName = paramString3;
    setPasswd(paramString4);
    setCatalogName(paramString6);
    setSchemaName(paramString7);
    this.datasourceName = paramString5;
  }

  public DBModel()
  {
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitDBModel(this);
  }

  public List getTables()
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < a().size(); i++)
    {
      if (!(a().get(i) instanceof TableModel))
        continue;
      localArrayList.add(a().get(i));
    }
    return localArrayList;
  }

  public List getProcedures()
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < a().size(); i++)
    {
      if (!(a().get(i) instanceof ProcedureModel))
        continue;
      localArrayList.add(a().get(i));
    }
    return localArrayList;
  }

  public List getViews()
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < a().size(); i++)
    {
      if (!(a().get(i) instanceof ViewModel))
        continue;
      localArrayList.add(a().get(i));
    }
    return localArrayList;
  }

  public String getVarTableName(String paramString)
  {
    String str = paramString;
    int i = 0;
    while (exitsTableVarName(str))
    {
      i++;
      str = paramString + i;
    }
    return str;
  }

  public void addChildElement(IElement paramIElement)
  {
    if ((paramIElement instanceof TableModel))
      addChildElement(paramIElement, getTableCount());
    else if ((paramIElement instanceof EnumTable))
      addChildElement(paramIElement, getChildrenCount());
    else if ((paramIElement instanceof SelectTable))
      addChildElement(paramIElement, getTableCount() + getSelectCount());
    else if ((paramIElement instanceof ProcedureModel))
      addChildElement(paramIElement, getTableCount() + getSelectCount() + getProcedureCount());
    else if ((paramIElement instanceof CustomSql))
      addChildElement(paramIElement, getTableCount() + getSelectCount() + getProcedureCount() + getCustomCount());
    else
      addChildElement(paramIElement, getChildrenCount());
  }

  public int getTableCount()
  {
    int i = 0;
    List localList = a();
    for (int j = 0; j < localList.size(); j++)
    {
      if (!(localList.get(j) instanceof TableModel))
        continue;
      i++;
    }
    return i;
  }

  public int getSelectCount()
  {
    int i = 0;
    List localList = a();
    for (int j = 0; j < localList.size(); j++)
    {
      if (!(localList.get(j) instanceof SelectTable))
        continue;
      i++;
    }
    return i;
  }

  public int getProcedureCount()
  {
    int i = 0;
    List localList = a();
    for (int j = 0; j < localList.size(); j++)
    {
      if (!(localList.get(j) instanceof ProcedureModel))
        continue;
      i++;
    }
    return i;
  }

  public int getCustomCount()
  {
    int i = 0;
    List localList = a();
    for (int j = 0; j < localList.size(); j++)
    {
      if (!(localList.get(j) instanceof CustomSql))
        continue;
      i++;
    }
    return i;
  }

  public boolean exitsTableVarName(String paramString)
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if ((localList.get(i) instanceof TableModel))
      {
        if (((TableModel)localList.get(i)).getVarName().equalsIgnoreCase(paramString))
          return true;
      }
      else if ((localList.get(i) instanceof SelectTable))
      {
        if (((SelectTable)localList.get(i)).getEnglishName().equalsIgnoreCase(paramString))
          return true;
      }
      else if ((localList.get(i) instanceof ProcedureModel))
      {
        if (((ProcedureModel)localList.get(i)).getEnglishName().equalsIgnoreCase(paramString))
          return true;
      }
      else if (((localList.get(i) instanceof SheetTable)) && (((SheetTable)localList.get(i)).getEnglishName().equalsIgnoreCase(paramString)))
        return true;
    return false;
  }

  public List getAllTables()
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < a().size(); i++)
    {
      if ((!(a().get(i) instanceof AbstractTableModel)) && (!(a().get(i) instanceof CustomSql)))
        continue;
      localArrayList.add(a().get(i));
    }
    return localArrayList;
  }

  public void updateDisplayNames()
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < a().size(); i++)
    {
      if (!(a().get(i) instanceof AbstractTableModel))
        continue;
      ((AbstractTableModel)a().get(i)).updateDisplayNames();
    }
  }

  public FKModel getFKModel(String paramString1, String paramString2)
  {
    for (int i = 0; i < a().size(); i++)
      if (((a().get(i) instanceof FKModel)) && (((FKModel)a().get(i)).isFKField(paramString1, paramString2)))
        return (FKModel)a().get(i);
    return null;
  }

  public List getFKModels(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < a().size(); i++)
    {
      if ((!(a().get(i) instanceof FKModel)) || ((!((FKModel)a().get(i)).getPkTableName().equalsIgnoreCase(paramString)) && (!((FKModel)a().get(i)).getFKTableName().equalsIgnoreCase(paramString))))
        continue;
      localArrayList.add(a().get(i));
    }
    return localArrayList;
  }

  public TableModel getTableModel(String paramString)
  {
    for (int i = 0; i < a().size(); i++)
    {
      if (!(a().get(i) instanceof TableModel))
        continue;
      TableModel localTableModel = (TableModel)a().get(i);
      if (localTableModel.getTableName().equalsIgnoreCase(paramString))
        return localTableModel;
    }
    return null;
  }

  public ProcedureModel getProcedureModel(String paramString)
  {
    for (int i = 0; i < a().size(); i++)
    {
      if (!(a().get(i) instanceof ProcedureModel))
        continue;
      ProcedureModel localProcedureModel = (ProcedureModel)a().get(i);
      if (localProcedureModel.getEnglishName().equalsIgnoreCase(paramString))
        return localProcedureModel;
    }
    return null;
  }

  public String getDriver()
  {
    return this.driver;
  }

  public String getPasswd()
  {
    return ConnectionFactory.decrypt(this.encryptedPasswd);
  }

  public String getUrl()
  {
    return this.url;
  }

  public String getUserName()
  {
    return this.userName;
  }

  public void setDriver(String paramString)
  {
    this.driver = paramString;
  }

  public void setPasswd(String paramString)
  {
    this.encryptedPasswd = ConnectionFactory.encrypt(paramString);
  }

  public void setUrl(String paramString)
  {
    this.url = paramString;
  }

  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }

  public String toString()
  {
    return this.driver + " " + this.url + " " + this.userName;
  }

  public String getName()
  {
    return "DBModel";
  }

  public IElement deepClone()
  {
    return new DBModel(this);
  }

  public boolean acceptNode(ITreeNode paramITreeNode)
  {
    if (b())
      return false;
    return ((paramITreeNode instanceof TableModel)) || ((paramITreeNode instanceof SelectTable)) || ((paramITreeNode instanceof CustomSql)) || ((paramITreeNode instanceof SheetTable)) || ((paramITreeNode instanceof ProcedureModel)) || ((paramITreeNode instanceof EnumTable));
  }

  public boolean acceptNode(String paramString)
  {
    if (b())
      return false;
    return (paramString.equals("TableModel")) || (paramString.equals("SheetTable")) || (paramString.equals("selectTable")) || (paramString.equals("CustomSql")) || (paramString.equals("ProcedureModel")) || (paramString.equals("EnumTable"));
  }

  public boolean canDelete()
  {
    return true;
  }

  public boolean canCopy()
  {
    return true;
  }

  public boolean canCut()
  {
    return false;
  }

  public boolean paste(IElement paramIElement)
  {
    Object localObject;
    if ((paramIElement instanceof TableModel))
    {
      localObject = (TableModel)paramIElement;
      if (exitsTableVarName(((TableModel)localObject).getVarName()))
        ((TableModel)localObject).changeVarName(getVarTableName(((TableModel)localObject).getShortTableName()));
    }
    else if ((paramIElement instanceof SelectTable))
    {
      localObject = (SelectTable)paramIElement;
      if (exitsTableVarName(((SelectTable)localObject).getEnglishName()))
        ((SelectTable)localObject).changeVarName(getVarTableName("select"));
    }
    else if ((paramIElement instanceof ProcedureModel))
    {
      localObject = (ProcedureModel)paramIElement;
      if (exitsTableVarName(((ProcedureModel)localObject).getEnglishName()))
        ((ProcedureModel)localObject).changeVarName(getVarTableName("proc"));
    }
    else if ((paramIElement instanceof SheetTable))
    {
      localObject = (SheetTable)paramIElement;
      if (exitsTableVarName(((SheetTable)localObject).getEnglishName()))
        ((SheetTable)localObject).changeVarName(getVarTableName("sheet"));
    }
    if (super.paste(paramIElement))
    {
      updateViewer();
      return true;
    }
    return false;
  }

  public boolean canRename()
  {
    return true;
  }

  protected boolean a(IElement paramIElement)
  {
    return super.a(paramIElement);
  }

  public String getEncryptedPasswd()
  {
    return this.encryptedPasswd;
  }

  public void setEncryptedPasswd(String paramString)
  {
    this.encryptedPasswd = paramString;
  }

  public String getDisplayName()
  {
    if (super.getDisplayName().length() > 0)
      return super.getDisplayName();
    if (getDatasourceName().length() > 0)
      return getDatasourceName();
    if (getUserName().length() > 0)
      return getUserName();
    return "DataBase";
  }

  public List getAvalibleTables()
  {
    ConnectionInfo localConnectionInfo = null;
    try
    {
      localConnectionInfo = getConnectionInfo();
      List localList = localConnectionInfo.getSchemaUtil().getTableNames();
      ArrayList localArrayList1 = new ArrayList(localList.size());
      for (int i = 0; i < localList.size(); i++)
      {
        if (getTableModel(localList.get(i).toString()) != null)
          continue;
        localArrayList1.add(localList.get(i));
      }
      ArrayList localArrayList2 = localArrayList1;
      return localArrayList2;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw localClassNotFoundException;
    }
    catch (SQLException localSQLException)
    {
      throw localSQLException;
    }
    finally
    {
      if ((localConnectionInfo != null) && (localConnectionInfo.getConnection() != null))
      {
        if (localConnectionInfo.getConnection().getAutoCommit())
          localConnectionInfo.getConnection().rollback();
        localConnectionInfo.getConnection().close();
      }
    }
    throw localObject;
  }

  public List getAvalibleProcedures()
  {
    ConnectionInfo localConnectionInfo = null;
    try
    {
      localConnectionInfo = getConnectionInfo();
      List localList = localConnectionInfo.getSchemaUtil().getProcedureNames();
      ArrayList localArrayList1 = new ArrayList(localList.size());
      for (int i = 0; i < localList.size(); i++)
      {
        if (getProcedureModel(localList.get(i).toString()) != null)
          continue;
        localArrayList1.add(localList.get(i));
      }
      ArrayList localArrayList2 = localArrayList1;
      return localArrayList2;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw localClassNotFoundException;
    }
    catch (SQLException localSQLException)
    {
      throw localSQLException;
    }
    finally
    {
      if ((localConnectionInfo != null) && (localConnectionInfo.getConnection() != null))
      {
        if (localConnectionInfo.getConnection().getAutoCommit())
          localConnectionInfo.getConnection().rollback();
        localConnectionInfo.getConnection().close();
      }
    }
    throw localObject;
  }

  public List getAvalibleViews()
  {
    ConnectionInfo localConnectionInfo = null;
    try
    {
      localConnectionInfo = getConnectionInfo();
      List localList = localConnectionInfo.getSchemaUtil().getViewNames();
      ArrayList localArrayList1 = new ArrayList(localList.size());
      for (int i = 0; i < localList.size(); i++)
      {
        if (getTableModel(localList.get(i).toString()) != null)
          continue;
        localArrayList1.add(localList.get(i));
      }
      ArrayList localArrayList2 = localArrayList1;
      return localArrayList2;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw localClassNotFoundException;
    }
    catch (SQLException localSQLException)
    {
      throw localSQLException;
    }
    finally
    {
      if ((localConnectionInfo != null) && (localConnectionInfo.getConnection() != null))
      {
        if (localConnectionInfo.getConnection().getAutoCommit())
          localConnectionInfo.getConnection().rollback();
        localConnectionInfo.getConnection().close();
      }
    }
    throw localObject;
  }

  public Connection getConnection()
  {
    Connection localConnection = getConnectionInfo().getConnection();
    if (!localConnection.getAutoCommit())
      localConnection.setAutoCommit(true);
    return localConnection;
  }

  public static String getConfigFileName(String paramString)
  {
    return paramString.replace('/', '.').replace(':', '.') + ".conf";
  }

  public ConnectionInfo getConnectionInfo()
  {
    if (DBModel.class.getClassLoader().getResource(getConfigFileName(getDatasourceName())) != null)
    {
      Properties localProperties = new Properties();
      try
      {
        localProperties.load(DBConfig.class.getClassLoader().getResourceAsStream(getConfigFileName(getDatasourceName())));
        String str1 = localProperties.getProperty("dbDriver", getDriver());
        String str2 = localProperties.getProperty("dbUrl", getUrl());
        String str3 = localProperties.getProperty("dbLogin", getUserName());
        String str4 = ConnectionFactory.decrypt(localProperties.getProperty("dbPassword", this.encryptedPasswd));
        ConnectionInfo localConnectionInfo = new ConnectionInfo(str1, str2, str3, str4, getCatalogName(), getSchemaName());
        ConnectionFactory.getConnection(localConnectionInfo);
        return localConnectionInfo;
      }
      catch (Exception localException)
      {
        n.a().b(getConfigFileName(getDatasourceName()) + " is error!", localException);
      }
    }
    return ConnectionFactory.getConnection(new ConnectionInfo(getDriver(), getUrl(), getUserName(), getPasswd(), getCatalogName(), getSchemaName()));
  }

  public void addTableModel(String paramString)
  {
    ConnectionInfo localConnectionInfo = null;
    try
    {
      localConnectionInfo = getConnectionInfo();
      SchemaUtil localSchemaUtil = localConnectionInfo.getSchemaUtil();
      SQLTable localSQLTable = localSchemaUtil.getTable(paramString);
      b.a(this).a(localSQLTable);
      TableModel localTableModel = new TableModel();
      addChildElement(localTableModel);
      localTableModel.update(localSQLTable);
      setModified(true);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw localClassNotFoundException;
    }
    catch (SQLException localSQLException)
    {
      throw localSQLException;
    }
    finally
    {
      if ((localConnectionInfo != null) && (localConnectionInfo.getConnection() != null))
      {
        if (localConnectionInfo.getConnection().getAutoCommit())
          localConnectionInfo.getConnection().rollback();
        localConnectionInfo.getConnection().close();
      }
    }
  }

  public void addViewModel(String paramString)
  {
    ConnectionInfo localConnectionInfo = null;
    try
    {
      localConnectionInfo = getConnectionInfo();
      SchemaUtil localSchemaUtil = localConnectionInfo.getSchemaUtil();
      SQLTable localSQLTable = localSchemaUtil.getView(paramString);
      ViewModel localViewModel = new ViewModel();
      addChildElement(localViewModel);
      localViewModel.update(localSQLTable);
      setModified(true);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw localClassNotFoundException;
    }
    catch (SQLException localSQLException)
    {
      throw localSQLException;
    }
    finally
    {
      if ((localConnectionInfo != null) && (localConnectionInfo.getConnection() != null))
      {
        if (localConnectionInfo.getConnection().getAutoCommit())
          localConnectionInfo.getConnection().rollback();
        localConnectionInfo.getConnection().close();
      }
    }
  }

  public void updateTableModel(TableModel paramTableModel)
  {
    ConnectionInfo localConnectionInfo = null;
    try
    {
      localConnectionInfo = getConnectionInfo();
      SchemaUtil localSchemaUtil = localConnectionInfo.getSchemaUtil();
      SQLTable localSQLTable = localSchemaUtil.getTable(paramTableModel.getTableName());
      if (localSQLTable != null)
      {
        b.a(this).a(localSQLTable);
        paramTableModel.update(localSQLTable);
      }
      setModified(true);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw localClassNotFoundException;
    }
    catch (SQLException localSQLException)
    {
      throw localSQLException;
    }
    finally
    {
      if ((localConnectionInfo != null) && (localConnectionInfo.getConnection() != null))
      {
        if (localConnectionInfo.getConnection().getAutoCommit())
          localConnectionInfo.getConnection().rollback();
        localConnectionInfo.getConnection().close();
      }
    }
  }

  public void updateProcedureModel(ProcedureModel paramProcedureModel)
  {
    ConnectionInfo localConnectionInfo = null;
    try
    {
      localConnectionInfo = getConnectionInfo();
      SchemaUtil localSchemaUtil = localConnectionInfo.getSchemaUtil();
      SQLProcedure localSQLProcedure = localSchemaUtil.getProcedure(paramProcedureModel.getEnglishName());
      if (localSQLProcedure != null)
        paramProcedureModel.update(localSQLProcedure);
      setModified(true);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw localClassNotFoundException;
    }
    catch (SQLException localSQLException)
    {
      throw localSQLException;
    }
    finally
    {
      if ((localConnectionInfo != null) && (localConnectionInfo.getConnection() != null))
      {
        if (localConnectionInfo.getConnection().getAutoCommit())
          localConnectionInfo.getConnection().rollback();
        localConnectionInfo.getConnection().close();
      }
    }
  }

  public void updateViewModel(ViewModel paramViewModel)
  {
    ConnectionInfo localConnectionInfo = null;
    try
    {
      localConnectionInfo = getConnectionInfo();
      SchemaUtil localSchemaUtil = localConnectionInfo.getSchemaUtil();
      SQLTable localSQLTable = localSchemaUtil.getView(paramViewModel.getTableName());
      paramViewModel.update(localSQLTable);
      setModified(true);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw localClassNotFoundException;
    }
    catch (SQLException localSQLException)
    {
      throw localSQLException;
    }
    finally
    {
      if ((localConnectionInfo != null) && (localConnectionInfo.getConnection() != null))
      {
        if (localConnectionInfo.getConnection().getAutoCommit())
          localConnectionInfo.getConnection().rollback();
        localConnectionInfo.getConnection().close();
      }
    }
  }

  public boolean checkCustomSql(String paramString)
  {
    ConnectionInfo localConnectionInfo = null;
    try
    {
      localConnectionInfo = getConnectionInfo();
      localConnectionInfo.setAutocommit(false);
      QueryUtil.testQuery(localConnectionInfo.getConnection(), a(paramString), b(paramString));
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw localClassNotFoundException;
    }
    catch (SQLException localSQLException)
    {
      throw localSQLException;
    }
    finally
    {
      if ((localConnectionInfo != null) && (localConnectionInfo.getConnection() != null))
      {
        if (localConnectionInfo.getConnection().getAutoCommit())
          localConnectionInfo.getConnection().rollback();
        localConnectionInfo.getConnection().close();
      }
    }
    throw localObject;
  }

  public boolean checkProcedure(String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, Object[] paramArrayOfObject)
  {
    ConnectionInfo localConnectionInfo = null;
    try
    {
      localConnectionInfo = getConnectionInfo();
      localConnectionInfo.setAutocommit(false);
      QueryUtil.executeProc(localConnectionInfo.getConnection(), paramString, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfObject);
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw localClassNotFoundException;
    }
    catch (SQLException localSQLException)
    {
      throw localSQLException;
    }
    finally
    {
      if ((localConnectionInfo != null) && (localConnectionInfo.getConnection() != null))
      {
        if (localConnectionInfo.getConnection().getAutoCommit())
          localConnectionInfo.getConnection().rollback();
        localConnectionInfo.getConnection().close();
      }
    }
    throw localObject;
  }

  public boolean checkSql(String paramString)
  {
    ConnectionInfo localConnectionInfo = null;
    try
    {
      localConnectionInfo = getConnectionInfo();
      localConnectionInfo.setAutocommit(false);
      QueryUtil.testQuery(localConnectionInfo.getConnection(), a(paramString), b(paramString));
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw localClassNotFoundException;
    }
    catch (SQLException localSQLException)
    {
      throw localSQLException;
    }
    finally
    {
      if ((localConnectionInfo != null) && (localConnectionInfo.getConnection() != null))
      {
        if (localConnectionInfo.getConnection().getAutoCommit())
          localConnectionInfo.getConnection().rollback();
        localConnectionInfo.getConnection().close();
      }
    }
    throw localObject;
  }

  public SelectTable createSelectTable(String paramString1, String paramString2, String paramString3)
  {
    ConnectionInfo localConnectionInfo = null;
    SelectTable localSelectTable = null;
    try
    {
      localConnectionInfo = getConnectionInfo();
      localSelectTable = new SelectTable(paramString1, paramString2, paramString3);
      addChildElement(localSelectTable);
      localSelectTable.update(QueryUtil.initQuery(localConnectionInfo.getConnection(), a(paramString1), b(paramString1)));
      setModified(true);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw localClassNotFoundException;
    }
    catch (SQLException localSQLException)
    {
      throw localSQLException;
    }
    finally
    {
      if ((localConnectionInfo != null) && (localConnectionInfo.getConnection() != null))
      {
        if (localConnectionInfo.getConnection().getAutoCommit())
          localConnectionInfo.getConnection().rollback();
        localConnectionInfo.getConnection().close();
      }
    }
    return localSelectTable;
  }

  public SheetTable createSheetTable(String paramString1, String paramString2, String paramString3)
  {
    ConnectionInfo localConnectionInfo = null;
    SheetTable localSheetTable = null;
    try
    {
      localSheetTable = new SheetTable(paramString1, getChildDefaultName(paramString2), paramString3);
      addChildElement(localSheetTable);
      if ((paramString1 != null) && (paramString1.length() > 0))
      {
        localConnectionInfo = getConnectionInfo();
        localSheetTable.update(QueryUtil.initQuery(localConnectionInfo.getConnection(), a(paramString1), b(paramString1)));
      }
      setModified(true);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw localClassNotFoundException;
    }
    catch (SQLException localSQLException)
    {
      throw localSQLException;
    }
    finally
    {
      if ((localConnectionInfo != null) && (localConnectionInfo.getConnection() != null))
      {
        if (localConnectionInfo.getConnection().getAutoCommit())
          localConnectionInfo.getConnection().rollback();
        localConnectionInfo.getConnection().close();
      }
    }
    return localSheetTable;
  }

  public void createEnumTable(String paramString1, String paramString2)
  {
    try
    {
      EnumTable localEnumTable = new EnumTable(getChildDefaultName(paramString2));
      addChildElement(localEnumTable);
      if ((paramString1 != null) && (paramString1.length() > 0))
        localEnumTable.changeSqlText(paramString1);
      setModified(true);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw localClassNotFoundException;
    }
    catch (SQLException localSQLException)
    {
      throw localSQLException;
    }
  }

  public void createProcedure(String paramString)
  {
    ConnectionInfo localConnectionInfo = null;
    try
    {
      localConnectionInfo = getConnectionInfo();
      SchemaUtil localSchemaUtil = localConnectionInfo.getSchemaUtil();
      SQLProcedure localSQLProcedure = localSchemaUtil.getProcedure(paramString);
      ProcedureModel localProcedureModel = new ProcedureModel(paramString, paramString);
      addChildElement(localProcedureModel);
      localProcedureModel.update(localSQLProcedure);
      setModified(true);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw localClassNotFoundException;
    }
    catch (SQLException localSQLException)
    {
      throw localSQLException;
    }
    finally
    {
      if ((localConnectionInfo != null) && (localConnectionInfo.getConnection() != null))
      {
        if (localConnectionInfo.getConnection().getAutoCommit())
          localConnectionInfo.getConnection().rollback();
        localConnectionInfo.getConnection().close();
      }
    }
  }

  public void createCustomSql(String paramString1, String paramString2, String paramString3)
  {
    CustomSql localCustomSql = new CustomSql(paramString1, paramString2, paramString3);
    addChildElement(localCustomSql);
    setModified(true);
  }

  public List getQueryUtil(String paramString)
  {
    ConnectionInfo localConnectionInfo = null;
    try
    {
      localConnectionInfo = getConnectionInfo();
      ArrayList localArrayList = QueryUtil.initQuery(localConnectionInfo.getConnection(), a(paramString), b(paramString));
      return localArrayList;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw localClassNotFoundException;
    }
    catch (SQLException localSQLException)
    {
      throw localSQLException;
    }
    finally
    {
      if ((localConnectionInfo != null) && (localConnectionInfo.getConnection() != null))
      {
        if (localConnectionInfo.getConnection().getAutoCommit())
          localConnectionInfo.getConnection().rollback();
        localConnectionInfo.getConnection().close();
      }
    }
    throw localObject;
  }

  public SQLProcedure getStatementUtil(String paramString)
  {
    ConnectionInfo localConnectionInfo = null;
    try
    {
      localConnectionInfo = getConnectionInfo();
      SchemaUtil localSchemaUtil = localConnectionInfo.getSchemaUtil();
      SQLProcedure localSQLProcedure1 = localSchemaUtil.getProcedure(paramString);
      SQLProcedure localSQLProcedure2 = localSQLProcedure1;
      return localSQLProcedure2;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw localClassNotFoundException;
    }
    catch (SQLException localSQLException)
    {
      throw localSQLException;
    }
    finally
    {
      if ((localConnectionInfo != null) && (localConnectionInfo.getConnection() != null))
      {
        if (localConnectionInfo.getConnection().getAutoCommit())
          localConnectionInfo.getConnection().rollback();
        localConnectionInfo.getConnection().close();
      }
    }
    throw localObject;
  }

  private String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramString.replace('\n', ' ').replace('\r', ' '));
    int i = 0;
    int j = 0;
    int k = 0;
    while (true)
    {
      i = localStringBuffer.indexOf("{", j);
      j = localStringBuffer.indexOf("}", i);
      if ((i >= j) || (i < 0))
        break;
      localStringBuffer.replace(i, j + 1, " ? ");
    }
    return localStringBuffer.toString();
  }

  private Object[] b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    StringBuffer localStringBuffer = new StringBuffer(paramString.replace('\n', ' ').replace('\r', ' '));
    int i = 0;
    int j = 0;
    List localList = c(paramString);
    while (true)
    {
      i = localStringBuffer.indexOf("{", j);
      j = localStringBuffer.indexOf("}", i);
      if ((i >= j) || (i < 0))
        break;
      if (localStringBuffer.substring(i + 1, j).indexOf("arg") < 0)
      {
        localArrayList.add(getTypeManager().d(localStringBuffer.substring(i + 1, j)));
        continue;
      }
      localArrayList.add(getTypeManager().d(a(localStringBuffer.substring(i + 1, j), localList)));
    }
    Object[] arrayOfObject = new Object[localArrayList.size()];
    for (int k = 0; k < localArrayList.size(); k++)
      arrayOfObject[k] = localArrayList.get(k);
    return arrayOfObject;
  }

  private String a(String paramString, List paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
      if (((MethodParam)paramList.get(i)).getParamName().equals(paramString))
        return ((MethodParam)paramList.get(i)).getTypeName();
    return "string";
  }

  private List c(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    StringBuffer localStringBuffer = new StringBuffer(paramString.replace('\n', ' ').replace('\r', ' '));
    int i = 0;
    int j = 0;
    int k = 0;
    while (true)
    {
      i = localStringBuffer.indexOf("{", j);
      j = localStringBuffer.indexOf("}", i);
      if ((i >= j) || (i < 0))
        break;
      if (localStringBuffer.substring(i + 1, j).indexOf("arg") >= 0)
        continue;
      localArrayList.add(new MethodParam(localStringBuffer.substring(i + 1, j).trim(), k++));
    }
    return localArrayList;
  }

  public String getVarName()
  {
    if (StringUtil.isJavaIdentifier(this.varName))
      return this.varName;
    if (getParent() != null)
      return "db" + getParent().getElementPos(this);
    if (StringUtil.isJavaIdentifier(getDisplayName()))
      return getDisplayName().toLowerCase();
    return getDatasourceName();
  }

  public SchemaUtil getSchema()
  {
    return this.schema;
  }

  public void setSchema(SchemaUtil paramSchemaUtil)
  {
    this.schema = paramSchemaUtil;
  }

  public String getDatasourceName()
  {
    if ((this.datasourceName == null) || (this.datasourceName.length() == 0))
      return getDisplayName();
    return this.datasourceName;
  }

  public void setDatasourceName(String paramString)
  {
    this.datasourceName = paramString;
  }

  public boolean isAutoCommit()
  {
    return this.connType == 1;
  }

  public void setAutoCommit(boolean paramBoolean)
  {
    if (paramBoolean)
      this.connType = 1;
    else
      this.connType = 0;
  }

  public String getCatalogName()
  {
    return this.catalogName;
  }

  public void setCatalogName(String paramString)
  {
    this.catalogName = paramString;
  }

  public String getSchemaName()
  {
    return this.schemaName;
  }

  public void setSchemaName(String paramString)
  {
    this.schemaName = paramString;
  }

  public int getConnType()
  {
    return this.connType;
  }

  public void setConnType(int paramInt)
  {
    this.connType = paramInt;
  }

  public String getDbFilePath()
  {
    return this.dbFilePath;
  }

  public void setDbFilePath(String paramString)
  {
    this.dbFilePath = paramString;
  }

  public boolean canCreateEditen()
  {
    return false;
  }

  public IBusinessObjectEditen createSubEditen(String paramString)
  {
    return null;
  }

  public boolean pasteElement(IElement paramIElement, int paramInt)
  {
    return paste(paramIElement.deepClone());
  }

  public List getAllEditens()
  {
    ArrayList localArrayList = new ArrayList();
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if ((localList.get(i) instanceof CustomSql))
      {
        localArrayList.addAll(((CustomSql)localList.get(i)).getAllEditens());
      }
      else
      {
        if (!(localList.get(i) instanceof IBusinessObjectEditen))
          continue;
        localArrayList.add(localList.get(i));
        IBusinessObjectEditen localIBusinessObjectEditen = (IBusinessObjectEditen)localList.get(i);
        localArrayList.addAll(localIBusinessObjectEditen.getAllSubEditens());
      }
    return localArrayList;
  }

  public Iterator getEditens()
  {
    ArrayList localArrayList = new ArrayList();
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if ((localList.get(i) instanceof CustomSql))
      {
        localArrayList.addAll(((CustomSql)localList.get(i)).d());
      }
      else
      {
        if (!(localList.get(i) instanceof IBusinessObjectEditen))
          continue;
        localArrayList.add(localList.get(i));
      }
    return localArrayList.iterator();
  }

  public void sortBy(int paramInt, String paramString, boolean paramBoolean)
  {
  }

  public List getCanCreateSubFunction()
  {
    return getEnvionment().getClassMembers(this, true);
  }

  public boolean createSubFunction(List paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
    {
      ((IBusinessObject)paramList.get(i)).setVisible(true);
      addChildElement((IBusinessObject)paramList.get(i));
    }
    return true;
  }

  public void changeValueType(String paramString)
  {
  }

  public List getAllParams()
  {
    return new ArrayList(0);
  }

  public IBusinessObjectContainer getContainer()
  {
    return this;
  }

  public g getJavaType()
  {
    return getTypeManager().a(getValueType());
  }

  public List getParams()
  {
    return new ArrayList(0);
  }

  public String getUniqueName()
  {
    return getVarName();
  }

  public String getValueName()
  {
    return getDatasourceName();
  }

  public String getValueType()
  {
    return "com.flagleader.db.Database";
  }

  public String getVarValue()
  {
    return getVarName();
  }

  public void setVisible(boolean paramBoolean)
  {
  }

  public boolean isEditVisible()
  {
    return false;
  }

  public boolean isLocked()
  {
    if ((getMainPackage() != null) && (!getMainPackage().isDeveloper()))
      return true;
    return super.isLocked();
  }

  public void setVarName(String paramString)
  {
    this.varName = paramString;
  }

  public List getAllTableAndFieldNames()
  {
    List localList = getTables();
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < localList.size(); i++)
    {
      localArrayList.add(((TableModel)localList.get(i)).getTableName());
      String[] arrayOfString = ((TableModel)localList.get(i)).getFieldNames();
      for (int j = 0; j < arrayOfString.length; j++)
        localArrayList.add(arrayOfString[j]);
    }
    return localArrayList;
  }

  public List getDBTableNames()
  {
    List localList = b.a(this).c();
    if (localList == null)
      return getAllTableAndFieldNames();
    return localList;
  }

  public List getDBTableFields(String paramString)
  {
    List localList = b.a(this).a(paramString);
    if (localList == null)
    {
      TableModel localTableModel = getTableModel(paramString);
      if (localTableModel != null)
        return localTableModel.getFieldNameList();
    }
    return localList;
  }

  public void setObjectEditor(d paramd)
  {
  }

  public void setModified(boolean paramBoolean)
  {
    super.setModified(paramBoolean);
    if ((paramBoolean) && (getEnvionment() != null))
      getEnvionment().setModified(true);
  }

  public void replaceVariables(List paramList1, List paramList2, List paramList3, List paramList4)
  {
  }

  public int getMinPos()
  {
    return 5;
  }

  public int getTransationlevel()
  {
    return this.transationlevel;
  }

  public void setTransationlevel(int paramInt)
  {
    this.transationlevel = paramInt;
  }

  public String getTransactionInfo()
  {
    switch (this.transationlevel)
    {
    case 1:
      return "java.sql.Connection.TRANSACTION_READ_UNCOMMITTED";
    case 2:
      return "java.sql.Connection.TRANSACTION_READ_COMMITTED";
    case 3:
      return "java.sql.Connection.TRANSACTION_REPEATABLE_READ";
    case 4:
      return "java.sql.Connection.TRANSACTION_SERIALIZABLE";
    }
    return "java.sql.Connection.TRANSACTION_NONE";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.db.DBModel
 * JD-Core Version:    0.6.0
 */