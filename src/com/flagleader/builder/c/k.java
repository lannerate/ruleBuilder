package com.flagleader.builder.c;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.bu;
import com.flagleader.manager.c.c.a;
import com.flagleader.manager.c.c.b;
import com.flagleader.manager.c.c.d;
import com.flagleader.manager.c.c.e;
import com.flagleader.manager.c.c.f;
import com.flagleader.manager.c.c.g;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rlm.lang.IMultiConditionToken;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public abstract class k extends v
  implements com.flagleader.manager.c.c
{
  private Table a;
  private TableEditor h;
  private TableItem i;

  public k(ITreeNode paramITreeNode, Composite paramComposite, bu parambu)
  {
    super(paramITreeNode, paramComposite, parambu);
  }

  protected Composite a(Composite paramComposite)
  {
    Composite localComposite = super.a(paramComposite);
    this.a = b(localComposite);
    a();
    return this.a;
  }

  protected Table b(Composite paramComposite)
  {
    this.a = new Table(paramComposite, 66304);
    this.a.setLayoutData(new GridData(1808));
    this.a.setHeaderVisible(true);
    this.a.setLinesVisible(true);
    this.h = new TableEditor(this.a);
    this.a.addMouseListener(new l(this));
    return this.a;
  }

  private void a(TableItem paramTableItem, Text paramText, TableEditor paramTableEditor, int paramInt, f paramf)
  {
    paramText.selectAll();
    paramTableEditor.horizontalAlignment = 16384;
    paramTableEditor.grabHorizontal = true;
    paramTableEditor.setEditor(paramText, paramTableItem, paramInt);
    paramText.addFocusListener(new n(this, paramf, paramText, paramTableItem, paramTableEditor));
    paramText.addTraverseListener(new o(this, paramf, paramText, paramTableItem, paramTableEditor));
  }

  private void a(TableItem paramTableItem, CCombo paramCCombo, TableEditor paramTableEditor, int paramInt, e parame)
  {
    paramCCombo.setItems(parame.b());
    paramCCombo.setText(paramTableItem.getText(paramInt));
    if (paramCCombo.getItemCount() < 20)
      paramCCombo.setVisibleItemCount(paramCCombo.getItemCount());
    else
      paramCCombo.setVisibleItemCount(20);
    paramTableEditor.horizontalAlignment = 16384;
    paramTableEditor.grabHorizontal = true;
    paramTableEditor.minimumWidth = 50;
    paramTableEditor.setEditor(paramCCombo, paramTableItem, paramInt);
    paramCCombo.addSelectionListener(new p(this, paramTableItem, paramCCombo, paramInt, parame));
    paramCCombo.addFocusListener(new q(this, paramCCombo));
    paramCCombo.addTraverseListener(new r(this, paramTableItem, paramCCombo, paramInt, parame));
  }

  private void a(TableItem paramTableItem, CCombo paramCCombo, int paramInt, e parame)
  {
    if ((this.i != null) && (!paramCCombo.isDisposed()))
    {
      this.i = null;
      if ((!f()) && (parame.a(paramCCombo.getSelectionIndex())) && (!paramTableItem.isDisposed()))
      {
        paramTableItem.setText(1, parame.b()[parame.a()]);
        update();
      }
    }
    a(paramCCombo);
  }

  private void a(TableItem paramTableItem, CCombo paramCCombo, TableEditor paramTableEditor, int paramInt, g paramg)
  {
    paramCCombo.setItems(paramg.a());
    paramCCombo.setText(paramTableItem.getText(paramInt));
    if (paramCCombo.getItemCount() < 20)
      paramCCombo.setVisibleItemCount(paramCCombo.getItemCount());
    else
      paramCCombo.setVisibleItemCount(20);
    paramTableEditor.horizontalAlignment = 16384;
    paramTableEditor.grabHorizontal = true;
    paramTableEditor.minimumWidth = 50;
    paramTableEditor.setEditor(paramCCombo, paramTableItem, paramInt);
    paramCCombo.addTraverseListener(new s(this, paramTableItem, paramCCombo, paramInt, paramg));
    paramCCombo.addFocusListener(new t(this, paramTableItem, paramCCombo, paramInt, paramg));
  }

  private void a(TableItem paramTableItem, CCombo paramCCombo, int paramInt, g paramg)
  {
    if ((this.i != null) && (!paramCCombo.isDisposed()))
    {
      this.i = null;
      if ((!f()) && (paramg.a(paramCCombo.getText())) && (!paramTableItem.isDisposed()))
      {
        paramTableItem.setText(1, paramg.b());
        update();
      }
    }
    a(paramCCombo);
  }

  private void a(CCombo paramCCombo)
  {
    if ((paramCCombo == null) || (paramCCombo.isDisposed()))
      return;
    if (this.h != null)
      this.h.setEditor(null, null, -1);
    if ((paramCCombo != null) && (!paramCCombo.isDisposed()))
      paramCCombo.dispose();
  }

  protected void a()
  {
    this.a.setLinesVisible(true);
    this.a.setHeaderVisible(true);
    TableColumn localTableColumn = new TableColumn(this.a, 0);
    localTableColumn.setText(ResourceTools.getMessage("key.ExportDialog"));
    if (this.g)
      localTableColumn.setWidth(70);
    else
      localTableColumn.setWidth(160);
    localTableColumn = new TableColumn(this.a, 0);
    localTableColumn.setText(ResourceTools.getMessage("value.ExportDialog"));
    if (this.g)
      localTableColumn.setWidth(400);
    else
      localTableColumn.setWidth(500);
  }

  protected abstract void a(Table paramTable);

  protected void a(String paramString1, String paramString2, h paramh)
  {
    TableItem localTableItem = new TableItem(this.a, 0);
    localTableItem.setText(0, paramString1);
    localTableItem.setText(1, paramString2);
    if (paramh != null)
      localTableItem.setData("action", paramh);
    localTableItem.setData("type", "dir");
    localTableItem.setData("value", paramString2);
  }

  protected void b(String paramString1, String paramString2, h paramh)
  {
    TableItem localTableItem = new TableItem(this.a, 0);
    localTableItem.setText(0, paramString1);
    localTableItem.setText(1, paramString2);
    if (paramh != null)
      localTableItem.setData("action", paramh);
    localTableItem.setData("type", "file");
    localTableItem.setData("value", paramString2);
  }

  protected void a(String paramString1, String paramString2, IMultiConditionToken paramIMultiConditionToken)
  {
    TableItem localTableItem = new TableItem(this.a, 0);
    localTableItem.setText(0, paramString1);
    localTableItem.setText(1, paramString2);
    if (paramIMultiConditionToken != null)
      localTableItem.setData("condition", paramIMultiConditionToken);
    localTableItem.setData("type", "logic");
  }

  protected void a(String paramString1, String paramString2, IMultiActionToken paramIMultiActionToken)
  {
    TableItem localTableItem = new TableItem(this.a, 0);
    localTableItem.setText(0, paramString1);
    localTableItem.setText(1, paramString2);
    if (paramIMultiActionToken != null)
      localTableItem.setData("catch", paramIMultiActionToken);
    localTableItem.setData("type", "catch");
  }

  public void a(String paramString, a parama, boolean paramBoolean)
  {
    TableItem localTableItem = new TableItem(this.a, 0);
    localTableItem.setText(0, paramString);
    localTableItem.setText(1, parama.b());
    if (paramBoolean)
      localTableItem.setData("monitor", parama);
  }

  public void a(String paramString, b paramb, boolean paramBoolean)
  {
    TableItem localTableItem = new TableItem(this.a, 0);
    localTableItem.setText(0, paramString);
    Button localButton = new Button(this.a, 32);
    localButton.setBackground(com.flagleader.builder.widget.h.b);
    localButton.setSelection(paramb.a());
    TableEditor localTableEditor = new TableEditor(this.a);
    localTableEditor.horizontalAlignment = 16384;
    localTableEditor.grabHorizontal = true;
    localTableEditor.setEditor(localButton, localTableItem, 1);
    if (f())
      localButton.setEnabled(false);
    else
      localButton.addSelectionListener(new u(this, paramb, localButton));
  }

  public void a(String paramString, com.flagleader.manager.c.c.c paramc, boolean paramBoolean)
  {
    TableItem localTableItem = new TableItem(this.a, 0);
    localTableItem.setText(0, paramString);
    localTableItem.setText(1, paramc.a());
    if (paramBoolean)
      localTableItem.setData("monitor", paramc);
  }

  public void a(String paramString, f paramf, boolean paramBoolean)
  {
    TableItem localTableItem = new TableItem(this.a, 0);
    localTableItem.setText(0, paramString);
    localTableItem.setText(1, paramf.a());
    if (paramBoolean)
      localTableItem.setData("monitor", paramf);
  }

  public void b(String paramString, f paramf, boolean paramBoolean)
  {
    TableItem localTableItem = new TableItem(this.a, 0);
    localTableItem.setText(0, paramString);
    localTableItem.setText(1, "*******************");
    if (paramBoolean)
    {
      localTableItem.setData("monitor", paramf);
      localTableItem.setData("type", "passwd");
    }
  }

  public void a(String paramString, e parame, boolean paramBoolean)
  {
    TableItem localTableItem = new TableItem(this.a, 0);
    localTableItem.setText(0, paramString);
    if ((parame.a() >= 0) && (parame.a() < parame.b().length))
      localTableItem.setText(1, parame.b()[parame.a()]);
    if (paramBoolean)
      localTableItem.setData("monitor", parame);
  }

  public void a(String paramString1, String paramString2)
  {
    TableItem localTableItem = new TableItem(this.a, 0);
    localTableItem.setText(0, paramString1);
    localTableItem.setText(1, paramString2);
  }

  public void a(String paramString, g paramg, boolean paramBoolean)
  {
    TableItem localTableItem = new TableItem(this.a, 0);
    localTableItem.setText(0, paramString);
    localTableItem.setText(1, paramg.b());
    if (paramBoolean)
      localTableItem.setData("monitor", paramg);
  }

  public void a(String paramString, d paramd, boolean paramBoolean)
  {
    TableItem localTableItem = new TableItem(this.a, 0);
    localTableItem.setText(0, paramString);
    localTableItem.setText(1, paramd.a());
    if (paramBoolean)
      localTableItem.setData("monitor", paramd);
  }

  public void a(f paramf)
  {
  }

  public void update()
  {
    if ((this.c == null) || (this.c.isDisposed()))
      return;
    this.a.removeAll();
    Control[] arrayOfControl = this.a.getChildren();
    for (int j = 0; j < arrayOfControl.length; j++)
      arrayOfControl[j].dispose();
    a(this.a);
    this.a.getColumn(1).pack();
    super.update();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.c.k
 * JD-Core Version:    0.6.0
 */