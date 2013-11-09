package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.f;
import com.flagleader.builder.widget.h;
import com.flagleader.repository.rlm.editen.ISheetWhereEditen;
import com.flagleader.repository.rlm.value.SheetWhere;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.IRuleContainer;
import java.util.List;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class bS extends f
{
  private static final int a = 450;
  private static final int b = 300;
  private String[] c;
  private String[] d;
  private IBusinessObject[] e;
  private Table f;
  private List g;
  private ISheetWhereEditen h = null;
  private TableEditor i;
  private TableItem j;
  private BuilderManager k;

  public bS(Shell paramShell, ISheetWhereEditen paramISheetWhereEditen, BuilderManager paramBuilderManager)
  {
    super(paramShell);
    this.h = paramISheetWhereEditen;
    this.k = paramBuilderManager;
    this.g = paramISheetWhereEditen.getSelectedFields();
    this.e = paramISheetWhereEditen.getCanSelectFields();
    this.c = paramISheetWhereEditen.getOperators();
    this.d = new String[this.e.length];
    for (int m = 0; m < this.e.length; m++)
      this.d[m] = this.e[m].getDisplayName();
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(new GridLayout());
    localComposite2.setLayoutData(new GridData(1808));
    d(localComposite2);
    Composite localComposite3 = new Composite(localComposite1, 0);
    localComposite3.setLayoutData(new GridData(1808));
    localComposite3.setLayout(a(7));
    e(localComposite3);
    b(localComposite1);
    return localComposite1;
  }

  private void d(Composite paramComposite)
  {
    f(paramComposite);
    b(this.f);
    a(this.f);
    this.i = new TableEditor(this.f);
    this.f.addKeyListener(new bT(this));
    this.f.addMouseMoveListener(new bV(this));
    this.f.addMouseListener(new bW(this));
  }

  private void g()
  {
    cd localcd = new cd(this);
    if ((localcd.open() == 0) && (localcd.d().length() > 0))
    {
      SheetWhere localSheetWhere = new SheetWhere(localcd.d(), this.e[localcd.c()]);
      this.h.addChildElement(localSheetWhere);
      localSheetWhere.setValue(localcd.b());
      localSheetWhere.setNaryType(localcd.a());
      TableItem localTableItem = new TableItem(this.f, 0);
      IBusinessObject localIBusinessObject = this.e[localcd.c()];
      localTableItem.setText(1, localcd.d());
      localTableItem.setText(0, localIBusinessObject.getDisplayName());
      localTableItem.setText(2, localcd.b());
      localTableItem.setText(3, localcd.a());
      localTableItem.setData(localSheetWhere);
      this.h.getRoot().setModified(true);
      this.h.update();
    }
  }

  private void h()
  {
    SheetWhere localSheetWhere1 = (SheetWhere)i().getData();
    int m = -1;
    for (int n = 0; n < this.e.length; n++)
    {
      if (!this.e[n].equals(localSheetWhere1.getField()))
        continue;
      m = n;
      break;
    }
    cd localcd = new cd(this, i().getText(1), m, i().getText(2), i().getText(3));
    if ((localcd.open() == 0) && ((!localcd.d().equals(i().getText(2))) || (m != localcd.c()) || (!localcd.b().equals(i().getText(0)))))
    {
      SheetWhere localSheetWhere2 = (SheetWhere)i().getData();
      localSheetWhere2.setFuncName(localcd.d());
      localSheetWhere2.setField(this.e[localcd.c()]);
      localSheetWhere2.setValue(localcd.b());
      localSheetWhere2.setNaryType(localcd.a());
      i().setText(2, localSheetWhere2.getValue());
      i().setText(0, localSheetWhere2.getField().getDisplayName());
      i().setText(1, localcd.d());
      i().setText(3, localcd.a());
      this.h.getRoot().setModified(true);
      this.h.update();
    }
  }

  private void a(TableItem paramTableItem, Text paramText, TableEditor paramTableEditor, int paramInt)
  {
    paramText.setFont(this.f.getFont());
    paramText.selectAll();
    paramTableEditor.horizontalAlignment = 16384;
    paramTableEditor.grabHorizontal = true;
    paramTableEditor.setEditor(paramText, this.j, paramInt);
    paramText.addFocusListener(new bX(this, paramText, paramTableItem, paramInt, paramTableEditor));
    paramText.addTraverseListener(new bY(this, paramText, paramTableItem, paramInt, paramTableEditor));
  }

  private void e(Composite paramComposite)
  {
    Button localButton1 = g(paramComposite);
    localButton1.setText(b("add.DataDialog"));
    localButton1.addSelectionListener(new bZ(this));
    Button localButton2 = g(paramComposite);
    localButton2.setText(b("edit.DataDialog"));
    localButton2.addSelectionListener(new ca(this));
    Button localButton3 = g(paramComposite);
    localButton3.setText(b("delete.DataDialog"));
    localButton3.addSelectionListener(new cb(this));
    localButton1 = g(paramComposite);
    localButton1.setText(ResourceTools.getMessage("moveUp.DataDialog"));
    localButton1.addSelectionListener(new cc(this));
    Button localButton4 = g(paramComposite);
    localButton4.setText(b("moveDown.DataDialog"));
    localButton4.addSelectionListener(new bU(this));
  }

  private Table f(Composite paramComposite)
  {
    this.f = new Table(paramComposite, 67586);
    GridData localGridData = new GridData();
    localGridData.widthHint = 450;
    localGridData.heightHint = 300;
    this.f.setLayoutData(localGridData);
    this.f.setLinesVisible(true);
    return this.f;
  }

  private void a(Table paramTable)
  {
    if (this.g != null)
      for (int m = 0; m < this.g.size(); m++)
      {
        TableItem localTableItem = new TableItem(paramTable, 0);
        SheetWhere localSheetWhere = (SheetWhere)this.g.get(m);
        IBusinessObject localIBusinessObject = localSheetWhere.getField();
        if (localIBusinessObject != null)
        {
          localTableItem.setText(new String[] { localIBusinessObject.getDisplayName(), localSheetWhere.getFuncName(), localSheetWhere.getValue(), localSheetWhere.getNaryType() });
        }
        else
        {
          localTableItem.setText(new String[] { b("notExits.TEXT"), localSheetWhere.getFuncName(), localSheetWhere.getValue(), localSheetWhere.getNaryType() });
          localTableItem.setBackground(h.g);
        }
        localTableItem.setData(localSheetWhere);
      }
  }

  private void b(Table paramTable)
  {
    paramTable.setLinesVisible(true);
    paramTable.setHeaderVisible(true);
    TableColumn localTableColumn = new TableColumn(paramTable, 0);
    localTableColumn.setText(b("fieldName.SelectSheetWheresDialog"));
    localTableColumn.setWidth(130);
    localTableColumn = new TableColumn(paramTable, 0);
    localTableColumn.setText(b("operateName.SelectSheetWheresDialog"));
    localTableColumn.setWidth(65);
    localTableColumn = new TableColumn(paramTable, 0);
    localTableColumn.setText(b("valueName.SelectSheetWheresDialog"));
    localTableColumn.setWidth(145);
    localTableColumn = new TableColumn(paramTable, 0);
    localTableColumn.setText(b("naryType.SelectSheetWheresDialog"));
    localTableColumn.setWidth(105);
  }

  private TableItem i()
  {
    if (this.f.getSelectionIndex() >= 0)
      return this.f.getSelection()[0];
    return null;
  }

  private Button g(Composite paramComposite)
  {
    Button localButton = new Button(paramComposite, 8);
    GridData localGridData = new GridData();
    localGridData.widthHint = 65;
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.horizontalIndent = 16;
    localButton.setLayoutData(localGridData);
    return localButton;
  }

  protected void okPressed()
  {
    this.h.update();
    close();
  }

  protected void a()
  {
    close();
  }

  public boolean b()
  {
    return false;
  }

  public boolean c()
  {
    return false;
  }

  public boolean d()
  {
    return this.f.getSelectionCount() > 0;
  }

  public boolean e()
  {
    return false;
  }

  public void f()
  {
    TableItem[] arrayOfTableItem = this.f.getSelection();
    for (int m = 0; m < arrayOfTableItem.length; m++)
    {
      ((SheetWhere)arrayOfTableItem[m].getData()).dispose();
      arrayOfTableItem[m].dispose();
    }
    this.h.getRoot().setModified(true);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.bS
 * JD-Core Version:    0.6.0
 */