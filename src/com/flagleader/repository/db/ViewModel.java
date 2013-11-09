package com.flagleader.repository.db;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.tree.ITreeNode;
import java.util.List;

public class ViewModel extends TableModel
{
  public static final String NAME = "ViewModel";

  public ViewModel(ViewModel paramViewModel)
  {
    super(paramViewModel);
  }

  public ViewModel()
  {
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitViewModel(this);
  }

  public String getName()
  {
    return "ViewModel";
  }

  public IElement deepClone()
  {
    return new ViewModel(this);
  }

  public void changeDisplayName(String paramString)
  {
    setDisplayName(paramString);
    getTableFunction("select").setDisplayName(format("select.table", new Object[] { getDisplayName() }));
    getTableFunction("hasNext").setDisplayName(format("hasNext.table", new Object[] { getDisplayName() }));
    getTableFunction("next").setDisplayName(format("next.table", new Object[] { getDisplayName() }));
    getTableFunction("getRows").setDisplayName(format("getRows.table", new Object[] { getDisplayName() }));
    getTableFunction("close").setDisplayName(format("close.table", new Object[] { getDisplayName() }));
    getTableFunction("first").setDisplayName(format("first.table", new Object[] { getDisplayName() }));
    getTableFunction("previous").setDisplayName(format("previous.table", new Object[] { getDisplayName() }));
    getTableFunction("last").setDisplayName(format("last.table", new Object[] { getDisplayName() }));
    getTableFunction("getListResult").setDisplayName(format("getAllBean.table", new Object[] { getDisplayName() }));
    getTableFunction("getCurrentRow").setDisplayName(format("getCurrentRow.table", new Object[] { getDisplayName() }));
    getTableFunction("gotoRow").setDisplayName(format("gotoRow.table", new Object[] { getDisplayName(), "{arg1}" }));
    List localList = getFields();
    for (int i = 0; i < localList.size(); i++)
      changeFieldDisplayName((FieldModel)localList.get(i));
    setModified(true);
    if ((getParent() != null) && ((getParent() instanceof ITreeNode)))
      ((ITreeNode)getParent()).setModified(true);
  }

  public void updateFunction()
  {
    if (getTableFunction("select") == null)
      addChildElement(new TableFunction("select", "void", "select()", format("select.table", new Object[] { getDisplayName() }), null, getLocalString("select.tablegroup")));
    if (getTableFunction("hasNext") == null)
      addChildElement(new TableFunction("hasNext", "boolean", "hasNext()", format("hasNext.table", new Object[] { getDisplayName() }), null, getLocalString("hasNext.tablegroup")));
    if (getTableFunction("next") == null)
      addChildElement(new TableFunction("next", "boolean", "next()", format("next.table", new Object[] { getDisplayName() }), null, getLocalString("next.tablegroup")));
    if (getTableFunction("getRows") == null)
      addChildElement(new TableFunction("getRows", "int", "getRows()", format("getRows.table", new Object[] { getDisplayName() }), null, getLocalString("getRows.tablegroup")));
    if (getTableFunction("close") == null)
      addChildElement(new TableFunction("close", "void", "close()", format("close.table", new Object[] { getDisplayName() }), null, getLocalString("close.tablegroup")));
    if (getTableFunction("first") == null)
      addChildElement(new TableFunction("first", "boolean", "first()", format("first.table", new Object[] { getDisplayName() }), null, getLocalString("first.tablegroup")));
    if (getTableFunction("previous") == null)
      addChildElement(new TableFunction("previous", "boolean", "previous()", format("previous.table", new Object[] { getDisplayName() }), null, getLocalString("previous.tablegroup")));
    if (getTableFunction("last") == null)
      addChildElement(new TableFunction("last", "boolean", "last()", format("last.table", new Object[] { getDisplayName() }), null, getLocalString("last.tablegroup")));
    if (getTableFunction("getListResult") == null)
      addChildElement(new TableFunction("getListResult", "list<list>", "getListResult()", format("getAllBean.table", new Object[] { getDisplayName() }), null, getLocalString("getAllBean.tablegroup")));
    if (getTableFunction("getCurrentRow") == null)
      addChildElement(new TableFunction("getCurrentRow", "int", "getCurrentRow()", format("getCurrentRow.table", new Object[] { getDisplayName() }), null, getLocalString("getCurrentRow.tablegroup")));
    if (getTableFunction("gotoRow") == null)
      addChildElement(new TableFunction("gotoRow", "boolean", "gotoRow({arg1})", format("gotoRow.table", new Object[] { getDisplayName(), "{arg1}" }), a("int"), getLocalString("gotoRow.tablegroup")));
  }

  public String getValueType()
  {
    return "com.flagleader.db.View";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.db.ViewModel
 * JD-Core Version:    0.6.0
 */