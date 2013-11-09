package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.b.q;
import com.flagleader.builder.dialogs.f;
import com.flagleader.builder.widget.h;
import com.flagleader.builder.widget.p;
import com.flagleader.repository.IElement;
import com.flagleader.repository.rlm.action.AbstractPackageField;
import com.flagleader.repository.rlm.action.PackageFieldGet;
import com.flagleader.repository.rlm.action.PackageFieldSet;
import com.flagleader.repository.rlm.editen.ISelectRulePackageEditen;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.IRuleContainer;
import java.util.List;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
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

public class C extends f
{
  private static final int b = 520;
  private static final int c = 300;
  private TableEditor d;
  private Text e;
  private Text f;
  private TableItem g;
  private BuilderManager h;
  private Table i;
  CTabFolder a;
  private ISelectRulePackageEditen j = null;

  public C(Shell paramShell, ISelectRulePackageEditen paramISelectRulePackageEditen, BuilderManager paramBuilderManager)
  {
    super(paramShell);
    this.j = paramISelectRulePackageEditen;
    this.h = paramBuilderManager;
  }

  private boolean g()
  {
    return this.a.getSelectionIndex() == 1;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(3));
    this.e = a(localComposite2, "rulepackage.SelectRulePackageDialog", 2048, 280, 12, 2);
    this.e.setText(this.j.getExeRuleName());
    this.e.addFocusListener(new D(this));
    Button localButton1 = f(localComposite2);
    localButton1.setText(b("selectrule.SelectRulePackageDialog"));
    localButton1.addSelectionListener(new K(this));
    this.f = a(localComposite2, "disRulePackage.SelectRulePackageDialog", 2048, 280, 12, 2);
    this.f.setEditable(false);
    this.f.setText(this.j.getExeRuleDisplay());
    Button localButton2 = f(localComposite2);
    localButton2.setText(b("reset.DataDialog"));
    localButton2.addSelectionListener(new L(this));
    this.a = new CTabFolder(localComposite1, 0);
    this.a.setLayoutData(a(540, 340));
    this.a.setLayout(new GridLayout());
    CTabItem localCTabItem = new CTabItem(this.a, 0);
    localCTabItem.setText(b("getfields.SelectRulePackageDialog"));
    Composite localComposite3 = new Composite(this.a, 0);
    localComposite3.setLayout(new GridLayout());
    localComposite3.setLayoutData(new GridData(1808));
    Table localTable1 = a(localComposite3, false);
    a(false);
    localCTabItem.setControl(localComposite3);
    localCTabItem = new CTabItem(this.a, 0);
    localCTabItem.setText(b("setfields.SelectRulePackageDialog"));
    localComposite3 = new Composite(this.a, 0);
    localComposite3.setLayout(new GridLayout());
    localComposite3.setLayoutData(new GridData(1808));
    Table localTable2 = a(localComposite3, false);
    a(true);
    localCTabItem.setControl(localComposite3);
    this.a.addSelectionListener(new M(this, localTable1, localTable2));
    Composite localComposite4 = new Composite(localComposite1, 0);
    localComposite4.setLayoutData(new GridData(1808));
    localComposite4.setLayout(a(7));
    d(localComposite4);
    b(localComposite1);
    this.a.setSelection(0);
    this.i = localTable1;
    return localComposite1;
  }

  private Table a(Composite paramComposite, boolean paramBoolean)
  {
    this.i = e(paramComposite);
    a(this.i, paramBoolean);
    this.i.addMouseMoveListener(new N(this));
    this.i.addMouseListener(new O(this));
    return this.i;
  }

  private void h()
  {
    S localS = new S(this);
    if (localS.open() == 0)
    {
      Object localObject = null;
      if (this.j.getSourceSheet() != null)
      {
        if (g())
          localObject = new PackageFieldSet(localS.c(), localS.d());
        else
          localObject = new PackageFieldGet(localS.c(), localS.d(), localS.e());
      }
      else if (g())
        localObject = new PackageFieldSet(localS.b(), localS.d());
      else
        localObject = new PackageFieldGet(localS.b(), localS.d(), localS.e());
      this.j.addChildElement((IElement)localObject);
      TableItem localTableItem = new TableItem(this.i, 0);
      localTableItem.setText(0, ((AbstractPackageField)localObject).getFuncName());
      localTableItem.setText(1, ((AbstractPackageField)localObject).getNaryType());
      localTableItem.setText(2, ((AbstractPackageField)localObject).getDisplayName());
      localTableItem.setText(3, ((AbstractPackageField)localObject).getValue());
      localTableItem.setData(localObject);
      this.j.setModified(true);
      this.j.update();
    }
  }

  private void i()
  {
    if (j() != null)
    {
      q localq = new q(getShell(), this.h, (AbstractPackageField)j().getData());
      if (localq.open() == 0)
      {
        AbstractPackageField localAbstractPackageField = (AbstractPackageField)j().getData();
        j().setText(3, localAbstractPackageField.getValue());
        this.j.setModified(true);
        this.j.update();
      }
    }
  }

  private void a(TableItem paramTableItem, int paramInt)
  {
    Text localText = new p().a(this.i, 4);
    localText.setText(this.g.getText(paramInt));
    this.d = new TableEditor(this.i);
    localText.setFont(this.i.getFont());
    localText.selectAll();
    this.d.horizontalAlignment = 16384;
    this.d.grabHorizontal = true;
    this.d.setEditor(localText, this.g, paramInt);
    localText.addFocusListener(new P(this, localText, paramTableItem, paramInt));
    localText.addTraverseListener(new Q(this, localText, paramTableItem, paramInt));
    localText.setFocus();
  }

  private void b(TableItem paramTableItem, int paramInt)
  {
    CCombo localCCombo = new CCombo(this.i, 8);
    List localList = this.j.getCanSelectSourceFields();
    String[] arrayOfString = (String[])null;
    if (paramInt == 0)
    {
      arrayOfString = new String[localList.size()];
      for (int k = 0; k < localList.size(); k++)
        arrayOfString[k] = (((IBusinessObject)localList.get(k)).getDisplayName() + "-" + ((IBusinessObject)localList.get(k)).getValueName() + "-" + ((IBusinessObject)localList.get(k)).getValueType());
    }
    localCCombo.setItems(arrayOfString);
    localCCombo.setText(paramTableItem.getText(paramInt));
    if (localCCombo.getItemCount() < 20)
      localCCombo.setVisibleItemCount(localCCombo.getItemCount());
    else
      localCCombo.setVisibleItemCount(20);
    this.d = new TableEditor(this.i);
    this.d.horizontalAlignment = 16384;
    this.d.grabHorizontal = true;
    this.d.minimumWidth = 50;
    this.d.setEditor(localCCombo, paramTableItem, paramInt);
    localCCombo.addFocusListener(new R(this, localCCombo, paramTableItem, paramInt, localList));
    localCCombo.addTraverseListener(new E(this, localCCombo, paramTableItem, paramInt, localList));
    localCCombo.setFocus();
  }

  private void d(Composite paramComposite)
  {
    Button localButton1 = f(paramComposite);
    localButton1.setText(b("add.DataDialog"));
    localButton1.addSelectionListener(new F(this));
    Button localButton2 = f(paramComposite);
    localButton2.setText(b("edit.DataDialog"));
    localButton2.addSelectionListener(new G(this));
    Button localButton3 = f(paramComposite);
    localButton3.setText(b("delete.DataDialog"));
    localButton3.addSelectionListener(new H(this));
    localButton1 = f(paramComposite);
    localButton1.setText(ResourceTools.getMessage("moveUp.DataDialog"));
    localButton1.addSelectionListener(new I(this));
    Button localButton4 = f(paramComposite);
    localButton4.setText(b("moveDown.DataDialog"));
    localButton4.addSelectionListener(new J(this));
  }

  private Table e(Composite paramComposite)
  {
    this.i = new Table(paramComposite, 68354);
    GridData localGridData = new GridData();
    localGridData.widthHint = 520;
    localGridData.heightHint = 300;
    this.i.setLayoutData(localGridData);
    this.i.setLinesVisible(true);
    return this.i;
  }

  private void a(boolean paramBoolean)
  {
    this.i.removeAll();
    Control[] arrayOfControl = this.i.getChildren();
    for (int k = 0; k < arrayOfControl.length; k++)
      arrayOfControl[k].dispose();
    List localList1 = null;
    if (paramBoolean)
      localList1 = this.j.getSelectedWheres();
    else
      localList1 = this.j.getSelectedFields();
    List localList2 = this.j.getCanSelectSourceFields();
    if (localList1 != null)
      for (int m = 0; m < localList1.size(); m++)
      {
        TableItem localTableItem = new TableItem(this.i, 0);
        AbstractPackageField localAbstractPackageField = (AbstractPackageField)localList1.get(m);
        localTableItem.setText(0, localAbstractPackageField.getFuncName());
        localTableItem.setText(1, localAbstractPackageField.getNaryType());
        localTableItem.setText(2, localAbstractPackageField.getDisplayName());
        localTableItem.setText(3, localAbstractPackageField.getValue());
        int n = 0;
        for (int i1 = 0; (localList2 != null) && (i1 < localList2.size()); i1++)
        {
          IBusinessObject localIBusinessObject = (IBusinessObject)localList2.get(i1);
          if ((!localIBusinessObject.getValueType().equals(localAbstractPackageField.getNaryType())) || (!localIBusinessObject.getValueName().equals(localAbstractPackageField.getFuncName())))
            continue;
          if (!localIBusinessObject.getDisplayName().equals(localAbstractPackageField.getDisplayName()))
          {
            localAbstractPackageField.setDisplayName(localIBusinessObject.getDisplayName());
            localAbstractPackageField.getRoot().setModified(true);
          }
          n = 1;
          break;
        }
        if (n == 0)
          localTableItem.setBackground(h.g);
        localTableItem.setData(localAbstractPackageField);
      }
  }

  private void a(Table paramTable, boolean paramBoolean)
  {
    paramTable.setLinesVisible(true);
    paramTable.setHeaderVisible(true);
    TableColumn localTableColumn;
    if (paramBoolean)
    {
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("sourceName.SelectRulePackageDialog"));
      localTableColumn.setWidth(100);
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("sourceType.SelectRulePackageDialog"));
      localTableColumn.setWidth(65);
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("sourceDisplay.SelectRulePackageDialog"));
      localTableColumn.setWidth(135);
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("variableName.SelectRulePackageDialog"));
      localTableColumn.setWidth(235);
    }
    else
    {
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("fieldName.SelectRulePackageDialog"));
      localTableColumn.setWidth(100);
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("valueType.SelectRulePackageDialog"));
      localTableColumn.setWidth(65);
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("displayName.SelectRulePackageDialog"));
      localTableColumn.setWidth(135);
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("valueName.SelectRulePackageDialog"));
      localTableColumn.setWidth(235);
    }
  }

  private TableItem j()
  {
    if (this.i.getSelectionIndex() >= 0)
      return this.i.getSelection()[0];
    return null;
  }

  private Button f(Composite paramComposite)
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
    this.j.update();
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
    return this.i.getSelectionCount() > 0;
  }

  public boolean e()
  {
    return false;
  }

  public void f()
  {
    TableItem[] arrayOfTableItem = this.i.getSelection();
    for (int k = 0; k < arrayOfTableItem.length; k++)
    {
      ((IElement)arrayOfTableItem[k].getData()).dispose();
      arrayOfTableItem[k].dispose();
    }
    this.j.setModified(true);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.C
 * JD-Core Version:    0.6.0
 */