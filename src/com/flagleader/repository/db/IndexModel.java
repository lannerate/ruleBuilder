package com.flagleader.repository.db;

import com.flagleader.database.SQLColumn;
import com.flagleader.database.SQLIndex;
import com.flagleader.repository.AbstractElement;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import java.util.List;

public class IndexModel extends AbstractElement
{
  private String indexName = "";
  private boolean unique = false;

  public IndexModel(IndexModel paramIndexModel)
  {
    super(paramIndexModel);
    this.indexName = paramIndexModel.indexName;
    this.unique = paramIndexModel.unique;
  }

  public IndexModel()
  {
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitIndexModel(this);
  }

  public String getName()
  {
    return "indexModel";
  }

  public String getIndexName()
  {
    return this.indexName;
  }

  public boolean isUnique()
  {
    return this.unique;
  }

  public void setIndexName(String paramString)
  {
    this.indexName = paramString;
  }

  public void setUnique(boolean paramBoolean)
  {
    this.unique = paramBoolean;
  }

  public IElement deepClone()
  {
    return new IndexModel(this);
  }

  public FieldModel[] getFieldModels()
  {
    FieldModel[] arrayOfFieldModel = new FieldModel[a().size()];
    for (int i = 0; i < a().size(); i++)
      arrayOfFieldModel[i] = getFieldModel(((FieldModel)a().get(i)).getFieldName());
    return arrayOfFieldModel;
  }

  public FieldModel getFieldModel(String paramString)
  {
    return getTable().getField(paramString);
  }

  public TableModel getTable()
  {
    return (TableModel)getParent();
  }

  public String getDisplayName()
  {
    if (super.getDisplayName().length() == 0)
      return getIndexName();
    return super.getDisplayName();
  }

  public void update(SQLIndex paramSQLIndex)
  {
    setIndexName(paramSQLIndex.getName());
    setUnique(paramSQLIndex.isUnique());
    String str = paramSQLIndex.getColumn().getName();
    FieldModel localFieldModel = getFieldModel(str);
    if (localFieldModel == null)
    {
      localFieldModel = new FieldModel();
      addChildElement(localFieldModel);
    }
    localFieldModel.update(paramSQLIndex.getColumn());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.db.IndexModel
 * JD-Core Version:    0.6.0
 */