package com.flagleader.builder.dialogs.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.i;
import com.flagleader.engine.IRuleLog;
import com.flagleader.manager.a.a.e;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class b extends com.flagleader.builder.dialogs.r
{
  private List a = new ArrayList();
  private i b = new i(true, true);
  private IRuleProject c;
  private Button d;
  private Button e;
  private List f;
  private BuilderManager g;
  private IRuleLog h = null;
  private int i = 1;
  private Table j;

  public b(BuilderManager paramBuilderManager)
  {
    super(new Shell());
    this.g = paramBuilderManager;
    super.setShellStyle(1168);
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.ListLogRecordsServerDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    GridData localGridData = new GridData(860, 550);
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.grabExcessVerticalSpace = true;
    localGridData.horizontalAlignment = 4;
    localGridData.verticalAlignment = 4;
    localComposite2.setLayoutData(localGridData);
    this.j = this.b.a(localComposite2, 67586);
    this.j.setLinesVisible(true);
    this.f = d();
    String[] arrayOfString1 = ResourceTools.getStringArray("Columns.ListLogRecordsServerDialog");
    String[] arrayOfString2 = ResourceTools.getStringArray("Types.ListLogRecordsServerDialog");
    String[] arrayOfString3 = ResourceTools.getStringArray("lengths.ListLogRecordsServerDialog");
    int[] arrayOfInt = new int[arrayOfString3.length];
    for (int k = 0; k < arrayOfString3.length; k++)
      arrayOfInt[k] = Integer.parseInt(arrayOfString3[k]);
    for (k = 0; k < arrayOfString1.length; k++)
      arrayOfString1[k] = a(arrayOfString1[k] + ".ListLogRecordsServerDialog");
    this.b.a(arrayOfString1, arrayOfInt, arrayOfString2);
    this.j.setHeaderVisible(true);
    this.j.setLayoutData(new GridData(1808));
    for (k = 0; (this.f != null) && (k < this.f.size()); k++)
    {
      localObject = (List)this.f.get(k);
      TableItem localTableItem = new TableItem(this.j, 0);
      localTableItem.setData(localObject);
      a(localTableItem, (List)localObject);
    }
    Composite localComposite3 = new Composite(localComposite2, 0);
    localComposite3.setLayout(a(2));
    this.d = new Button(localComposite3, 8);
    this.d.setText(a("prepage.ListLogRecordsServerDialog"));
    this.d.addSelectionListener(new c(this));
    Object localObject = new Button(localComposite3, 8);
    ((Button)localObject).setText(a("nextpage.ListLogRecordsServerDialog"));
    ((Button)localObject).addSelectionListener(new d(this));
    return (Control)localComposite1;
  }

  private void c()
  {
    this.f = d();
    this.j.removeAll();
    for (int k = 0; (this.f != null) && (k < this.f.size()); k++)
    {
      List localList = (List)this.f.get(k);
      TableItem localTableItem = new TableItem(this.j, 0);
      localTableItem.setData(localList);
      a(localTableItem, localList);
    }
  }

  private void a(TableItem paramTableItem, List paramList)
  {
    for (int k = 0; k < paramList.size(); k++)
      if (paramList.get(k) == null)
        paramTableItem.setText(k, "");
      else
        paramTableItem.setText(k, StringUtil.stringValue(paramList.get(k)));
    paramTableItem.setData(paramList);
  }

  private List d()
  {
    try
    {
      e locale = this.g.getRulesManager().q();
      List localList = locale.a(this.i, 200);
      if (localList == null)
      {
        MessageDialog.openError(getShell(), "", locale.i());
        return Collections.EMPTY_LIST;
      }
      return localList;
    }
    catch (Exception localException)
    {
      MessageDialog.openError(getShell(), "", localException.getLocalizedMessage());
    }
    return Collections.EMPTY_LIST;
  }

  protected void okPressed()
  {
    if (this.j.getSelectionCount() != 1)
    {
      MessageDialog.openError(getShell(), "", "nothing select");
      return;
    }
    TableItem localTableItem = this.j.getSelection()[0];
    try
    {
      e locale = this.g.getRulesManager().q();
      this.h = locale.a(Integer.parseInt(localTableItem.getText(0)));
    }
    catch (Exception localException)
    {
      MessageDialog.openError(getShell(), "", localException.getLocalizedMessage());
      return;
    }
    super.okPressed();
  }

  public List a()
  {
    return this.a;
  }

  public IRuleLog b()
  {
    return this.h;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.g.b
 * JD-Core Version:    0.6.0
 */