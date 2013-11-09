package com.flagleader.builder.a.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.db.Sheet;
import com.flagleader.engine.IRuleLog;
import com.flagleader.engine.Property;
import com.flagleader.manager.e.K;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.TestCase;
import com.flagleader.repository.tree.TestObjectInfo;
import com.flagleader.util.StringUtil;
import com.flagleader.xml.Node;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class k extends aS
  implements IElementViewer
{
  private Table f;
  private TableItem g;
  private TableItem q;
  private TableEditor r;
  private int s = 7;
  int e = 0;
  private K t;

  public k(TestCase paramTestCase, Composite paramComposite, bu parambu)
  {
    super(paramTestCase, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new k((TestCase)this.c, paramComposite, this.a);
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.a(paramComposite);
    this.f = new Table(localComposite, 65536);
    GridData localGridData = new GridData();
    localGridData.horizontalAlignment = 4;
    localGridData.verticalAlignment = 4;
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.grabExcessVerticalSpace = true;
    this.f.setLayoutData(localGridData);
    this.f.setHeaderVisible(true);
    this.f.setLinesVisible(true);
    i();
    this.f.setVisible(true);
    this.f.addMouseListener(new o(this));
    return localComposite;
  }

  protected void h()
  {
    a(new n(this));
    super.h();
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "go");
    new ToolItem(paramToolBar, 2);
    super.a(paramToolBar);
  }

  private TestCase g()
  {
    return (TestCase)this.c;
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()) || ((this.a != null) && (!equals(this.a.e()))))
      return;
    i();
    j();
    super.update();
  }

  public boolean needUpdate()
  {
    return (this.d == 0L) || (this.d < this.c.getMaxModifyTime()) || (this.d < g().getEnvionment().getMaxModifyTime());
  }

  private void i()
  {
    while (this.f.getColumnCount() > 0)
      this.f.getColumn(0).dispose();
    TableColumn localTableColumn = new TableColumn(this.f, 0);
    this.s = 6;
    localTableColumn.setText(ResourceTools.getMessage("AttributeName.Test"));
    localTableColumn.setWidth(80);
    localTableColumn = new TableColumn(this.f, 0);
    localTableColumn.setText(ResourceTools.getMessage("Type.test"));
    localTableColumn.setWidth(80);
    localTableColumn = new TableColumn(this.f, 0);
    localTableColumn.setText(ResourceTools.getMessage("InitialValue.test"));
    localTableColumn.setWidth(110);
    localTableColumn = new TableColumn(this.f, 0);
    localTableColumn.setText(ResourceTools.getMessage("ExpectValue.test"));
    localTableColumn.setWidth(110);
    localTableColumn = new TableColumn(this.f, 0);
    localTableColumn.setText(ResourceTools.getMessage("ResultValue.test"));
    localTableColumn.setWidth(110);
    localTableColumn = new TableColumn(this.f, 0);
    localTableColumn.setText(ResourceTools.getMessage("displayName.test"));
    localTableColumn.setWidth(80);
  }

  private void a(TableItem paramTableItem)
  {
    this.g = paramTableItem;
  }

  public void e()
  {
    this.e = 0;
    this.t = ((K)a().getRulesManager().l().a(g()));
    z();
    a(this.t.q(), false, true);
    C();
    a().getShell().setCursor(a().getShell().getDisplay().getSystemCursor(3));
    l locall = new l(this);
    Display.getCurrent().timerExec(100, locall);
  }

  public void f()
  {
    this.p = this.e;
    b(this.p);
    z();
    this.f.getDisplay().asyncExec(new m(this));
  }

  private void j()
  {
    this.f.removeAll();
    Control[] arrayOfControl = this.f.getChildren();
    for (int i = 0; i < arrayOfControl.length; i++)
      arrayOfControl[i].dispose();
    Object localObject;
    try
    {
      g().updateInfo();
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localObject = ResourceTools.formatMessage("classNotFoundError", new String[] { localClassNotFoundException.getMessage() });
      a().getRulesManager().j().a((String)localObject);
      MessageDialog.openError(this.b.getShell(), null, (String)localObject);
    }
    Iterator localIterator = g().getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject = (TestObjectInfo)localIterator.next();
      TableItem localTableItem = new TableItem(this.f, 8);
      localTableItem.setData("info", localObject);
      int j = 0;
      localTableItem.setText(j++, ((TestObjectInfo)localObject).getMemberName());
      localTableItem.setText(j++, ((TestObjectInfo)localObject).getType());
      localTableItem.setText(j++, ((TestObjectInfo)localObject).getInitialValue());
      localTableItem.setText(j++, ((TestObjectInfo)localObject).getExpectValue());
      if ((((TestObjectInfo)localObject).isOutVariable()) && (((TestObjectInfo)localObject).isChanged()))
        localTableItem.setForeground(j, com.flagleader.builder.widget.h.g);
      if ((((TestObjectInfo)localObject).getResultValue() != null) && ((((TestObjectInfo)localObject).getResultValue() instanceof List)) && (((List)((TestObjectInfo)localObject).getResultValue()).size() > 0))
      {
        localTableItem.setData(((TestObjectInfo)localObject).getResultValue());
        if ((((List)((TestObjectInfo)localObject).getResultValue()).size() > 0) && ((((List)((TestObjectInfo)localObject).getResultValue()).get(0) instanceof List)))
        {
          List localList = (List)((List)((TestObjectInfo)localObject).getResultValue()).get(0);
          String str = "";
          for (int k = 0; k < localList.size(); k++)
          {
            if (localList.get(k) == null)
              continue;
            str = str + localList.get(k).toString() + ",";
          }
          localTableItem.setText(j++, str);
        }
        else
        {
          localTableItem.setText(j++, a(((List)((TestObjectInfo)localObject).getResultValue()).get(0)));
        }
      }
      else if ((((TestObjectInfo)localObject).getResultValue() != null) && ((((TestObjectInfo)localObject).getResultValue() instanceof IRuleLog)))
      {
        localTableItem.setData(((TestObjectInfo)localObject).getResultValue());
        localTableItem.setText(j++, ResourceTools.getMessage("logClick.Test"));
      }
      else if ((((TestObjectInfo)localObject).getResultValue() != null) && ((((TestObjectInfo)localObject).getResultValue() instanceof Sheet)))
      {
        localTableItem.setData(((TestObjectInfo)localObject).getResultValue());
        localTableItem.setText(j++, ResourceTools.getMessage("logClick.Test"));
      }
      else if ((((TestObjectInfo)localObject).getResultValue() != null) && ((((TestObjectInfo)localObject).getResultValue() instanceof Node)))
      {
        localTableItem.setData(((TestObjectInfo)localObject).getResultValue());
        localTableItem.setText(j++, ((Node)((TestObjectInfo)localObject).getResultValue()).getContent());
      }
      else
      {
        localTableItem.setText(j++, a(((TestObjectInfo)localObject).getResultValue()));
      }
      localTableItem.setText(j++, ((TestObjectInfo)localObject).getDisplayName());
    }
  }

  private String a(Object paramObject)
  {
    if (paramObject == null)
      return "";
    try
    {
      if ((paramObject instanceof String))
        return (String)paramObject;
      if ((paramObject instanceof byte[]))
        return new String((byte[])paramObject);
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
    return StringUtil.stringValue(paramObject);
  }

  public String getCompositeUuid()
  {
    return g().getEditUuid();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.g.k
 * JD-Core Version:    0.6.0
 */