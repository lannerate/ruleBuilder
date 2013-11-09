package com.flagleader.builder.a.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.bu;
import com.flagleader.manager.d.b;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.DecisionMultiRule;
import com.flagleader.repository.tree.DecisionRule;
import com.flagleader.repository.tree.DecisionValue;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;

public class aN extends com.flagleader.builder.a.aS
  implements IElementViewer
{
  private Table e;
  private TableEditor f;
  private Text g;

  public aN(DecisionRule paramDecisionRule, Composite paramComposite, bu parambu)
  {
    super(paramDecisionRule, paramComposite, parambu);
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.a(paramComposite);
    b(localComposite);
    return localComposite;
  }

  protected void h()
  {
    a(new aR(this));
    a(new aS(this));
    super.h();
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "import");
    a(paramToolBar, "export");
    super.a(paramToolBar);
  }

  private DecisionRule f()
  {
    return (DecisionRule)this.c;
  }

  public void b(Composite paramComposite)
  {
    this.e = new Table(paramComposite, 66304);
    this.e.setLayoutData(new GridData(1808));
    this.e.setHeaderVisible(true);
    this.e.setLinesVisible(true);
    this.f = new TableEditor(this.e);
    this.f.horizontalAlignment = 16384;
    this.f.grabHorizontal = true;
    if (!f().isLocked())
      this.e.addMouseListener(new aO(this));
  }

  private void g()
  {
    this.f.setEditor(null, null, -1);
    if ((this.g != null) && (!this.g.isDisposed()))
    {
      this.g.dispose();
      this.g = null;
    }
    if ((!this.c.isLocked()) && (a().getConfigManager().E()))
      a().getRulesManager().c().a(f());
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()))
      return;
    this.e.removeAll();
    Control[] arrayOfControl = this.e.getChildren();
    for (int i = 0; i < arrayOfControl.length; i++)
      arrayOfControl[i].dispose();
    while (this.e.getColumnCount() > 0)
      this.e.getColumn(0).dispose();
    TableColumn localTableColumn = new TableColumn(this.e, 0);
    if (f().getMemberElement() != null)
      localTableColumn.setText(f().getMemberElement().getDisplayName());
    else
      localTableColumn.setText("");
    localTableColumn.setWidth(100);
    List localList1 = f().getFirstConditions().getConditionList();
    for (int j = 0; j < localList1.size(); j++)
    {
      localTableColumn = new TableColumn(this.e, 0);
      localTableColumn.setText(localList1.get(j).toString());
      localTableColumn.setWidth(100);
    }
    List localList2 = f().getSecondConditions().getConditionList();
    for (int k = 0; k < localList2.size(); k++)
    {
      TableItem localTableItem = new TableItem(this.e, 0);
      localTableItem.setText(0, localList2.get(k).toString());
      localTableItem.setForeground(0, Display.getDefault().getSystemColor(9));
      for (int m = 0; m < localList1.size(); m++)
      {
        if (f().getDecisionValue(m, k) != null)
          localTableItem.setText(m + 1, f().getDecisionValue(m, k).getDisplayName());
        else
          localTableItem.setText(m + 1, "");
        localTableItem.setForeground(m + 1, Display.getDefault().getSystemColor(3));
      }
      localTableItem.setData("y", new Integer(k));
    }
    for (k = 0; k < this.e.getColumnCount(); k++)
      this.e.getColumns()[k].pack();
    super.update();
  }

  public boolean needUpdate()
  {
    return (this.d == 0L) || (this.d < f().getMaxModifyTime()) || (this.d < f().getEnvionment().getMaxModifyTime());
  }

  public String getCompositeUuid()
  {
    return f().getEditUuid() + "value";
  }

  void e()
  {
    FileDialog localFileDialog = new FileDialog(new Shell(), 8192);
    localFileDialog.setFilterExtensions(new String[] { "*.xls", "*.xlsx" });
    localFileDialog.setFileName(f().getDisplayName());
    if (localFileDialog.open() != null)
      try
      {
        f().exportXsl(localFileDialog.getFilterPath() + File.separator + localFileDialog.getFileName());
        MessageDialog.openInformation(new Shell(), "", c.a("HasBeenExport", new String[] { localFileDialog.getFilterPath() + File.separator + localFileDialog.getFileName() }));
      }
      catch (IOException localIOException)
      {
        MessageDialog.openError(new Shell(), "file error!", localIOException.getMessage());
      }
  }

  protected com.flagleader.builder.a.aS e(Composite paramComposite)
  {
    return new a((DecisionMultiRule)this.c, paramComposite, this.a);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.aN
 * JD-Core Version:    0.6.0
 */