package com.flagleader.repository.db;

import com.flagleader.repository.AbstractElement;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.tree.AdvancedProperty;
import com.flagleader.sql.RuleKey;
import java.util.ArrayList;

public class FKModel extends AbstractElement
{
  private String pkTableName = "";
  private int pkType = 0;
  private String FKTableName = "";
  private int fkType = 0;
  private String FKName = "";
  private String PKName = "";
  private String defaultValue = "NULL";
  private int updateRule = 0;
  private int deleteRule = 0;
  ArrayList a = new ArrayList(1);

  public FKModel(FKModel paramFKModel)
  {
    super(paramFKModel);
    this.pkTableName = paramFKModel.pkTableName;
    this.pkType = paramFKModel.pkType;
    this.FKTableName = paramFKModel.FKTableName;
    this.fkType = paramFKModel.fkType;
    this.FKName = paramFKModel.FKName;
    this.PKName = paramFKModel.PKName;
    this.defaultValue = paramFKModel.defaultValue;
    this.updateRule = paramFKModel.updateRule;
    this.deleteRule = paramFKModel.deleteRule;
  }

  public FKModel(String paramString1, String paramString2)
  {
    this.pkTableName = paramString1;
    this.FKTableName = paramString2;
  }

  public FKModel(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    this.pkTableName = paramString1;
    this.pkType = paramInt1;
    this.FKTableName = paramString2;
    this.fkType = paramInt2;
  }

  public FKModel()
  {
  }

  public String toString()
  {
    return this.FKName;
  }

  public String getName()
  {
    return "fkModel";
  }

  public String getFKTableName()
  {
    return this.FKTableName;
  }

  public void setFieldName(String paramString)
  {
    if (this.a.size() == 0)
      this.a.add(new AdvancedProperty());
    ((AdvancedProperty)this.a.get(0)).setKey(paramString);
  }

  public void addKey(String paramString1, String paramString2)
  {
    this.a.add(new AdvancedProperty(paramString1, paramString2));
  }

  public void setFKFieldName(String paramString)
  {
    if (this.a.size() == 0)
      this.a.add(new AdvancedProperty());
    ((AdvancedProperty)this.a.get(0)).setProperty(paramString);
  }

  public boolean isFKField(String paramString1, String paramString2)
  {
    if (getFKTableName().equalsIgnoreCase(paramString1))
      for (int i = 0; i < this.a.size(); i++)
        if (((AdvancedProperty)this.a.get(i)).getProperty().equalsIgnoreCase(paramString2))
          return true;
    return false;
  }

  public String getPkFieldNames()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < this.a.size(); i++)
    {
      localStringBuffer.append(((AdvancedProperty)this.a.get(i)).getKey());
      if (i >= this.a.size() - 1)
        continue;
      localStringBuffer.append(",");
    }
    return localStringBuffer.toString();
  }

  public boolean isFriendkey(String paramString1, String paramString2)
  {
    return (this.FKTableName.equalsIgnoreCase(paramString1)) && (this.a.size() == 1) && (((AdvancedProperty)this.a.get(0)).getProperty().equalsIgnoreCase(paramString2));
  }

  public String getFkFieldNames()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < this.a.size(); i++)
    {
      localStringBuffer.append(((AdvancedProperty)this.a.get(i)).getProperty());
      if (i >= this.a.size() - 1)
        continue;
      localStringBuffer.append(",");
    }
    return localStringBuffer.toString();
  }

  public void setFKTableName(String paramString)
  {
    this.FKTableName = paramString;
  }

  public String getPkTableName()
  {
    return this.pkTableName;
  }

  public void setPkTableName(String paramString)
  {
    this.pkTableName = paramString;
  }

  public String getFKName()
  {
    if ((this.FKName == null) || (this.FKName.length() == 0))
      return "FK_" + this.pkTableName + "_" + this.FKTableName;
    return this.FKName;
  }

  public void setFKName(String paramString)
  {
    if (paramString != null)
      this.FKName = paramString;
  }

  public String getPKName()
  {
    return this.PKName;
  }

  public void setPKName(String paramString)
  {
    if (paramString != null)
      this.PKName = paramString;
  }

  public int getDeleteRule()
  {
    return this.deleteRule;
  }

  public void setDeleteRule(int paramInt)
  {
    this.deleteRule = paramInt;
  }

  public int getUpdateRule()
  {
    return this.updateRule;
  }

  public void setUpdateRule(int paramInt)
  {
    this.updateRule = paramInt;
  }

  public String getDefaultValue()
  {
    return this.defaultValue;
  }

  public void setDefaultValue(String paramString)
  {
    this.defaultValue = paramString;
  }

  public RuleKey getRuleKey()
  {
    RuleKey localRuleKey = new RuleKey(this.pkTableName, getPkFieldNames(), this.FKTableName, getFkFieldNames(), this.updateRule, this.deleteRule, this.defaultValue);
    return localRuleKey;
  }

  public int getPkType()
  {
    return this.pkType;
  }

  public void setPkType(int paramInt)
  {
    this.pkType = paramInt;
  }

  public int getFkType()
  {
    return this.fkType;
  }

  public void setFkType(int paramInt)
  {
    this.fkType = paramInt;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitFKModel(this);
  }

  public IElement deepClone()
  {
    return new FKModel(this);
  }

  public ArrayList getKeys()
  {
    return this.a;
  }

  public void addAdvanceProperty(AdvancedProperty paramAdvancedProperty)
  {
    a(paramAdvancedProperty.getKey());
    this.a.add(paramAdvancedProperty);
  }

  private void a(String paramString)
  {
    for (int i = 0; i < this.a.size(); i++)
    {
      if (!((AdvancedProperty)this.a.get(i)).getKey().equals(paramString))
        continue;
      this.a.remove(i);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.db.FKModel
 * JD-Core Version:    0.6.0
 */