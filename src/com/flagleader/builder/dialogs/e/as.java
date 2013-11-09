package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.f;
import com.flagleader.builder.widget.h;
import com.flagleader.repository.IElement;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.editen.ISheetAndWhereEditen;
import com.flagleader.repository.rlm.value.SheetFieldMapping;
import com.flagleader.repository.rlm.value.SheetWhere;
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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class as extends f
{
  private static final int b = 450;
  private static final int c = 300;
  private TableEditor d;
  private Combo e;
  private TableItem f;
  private BuilderManager g;
  private Table h;
  CTabFolder a;
  private List i;
  private String[] j;
  private String[] k;
  private List l;
  private ISheetAndWhereEditen m = null;

  public as(Shell paramShell, ISheetAndWhereEditen paramISheetAndWhereEditen, BuilderManager paramBuilderManager)
  {
    super(paramShell);
    this.m = paramISheetAndWhereEditen;
    this.g = paramBuilderManager;
    this.l = paramISheetAndWhereEditen.getCanSelectFields();
    if ((this.l != null) && (this.l.size() > 0))
    {
      this.j = new String[this.l.size()];
      for (n = 0; n < this.l.size(); n++)
        this.j[n] = ((IBusinessObject)this.l.get(n)).getDisplayName();
    }
    else
    {
      this.j = new String[0];
    }
    this.i = paramISheetAndWhereEditen.getCanSelectSources();
    this.k = new String[this.i.size()];
    for (int n = 0; n < this.i.size(); n++)
      this.k[n] = ((IElement)this.i.get(n)).getDisplayName();
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
    this.e = b(localComposite2, "sheet.SelectSheetAndFieldsDialog", 2048, 280, 12, 2);
    this.e.setItems(this.k);
    if (this.e.getItemCount() < 20)
      this.e.setVisibleItemCount(this.e.getItemCount());
    else
      this.e.setVisibleItemCount(20);
    if (this.m.getSourceSheet() != null)
      for (int n = 0; n < this.i.size(); n++)
      {
        if (!this.m.getSourceSheet().equals(this.i.get(n)))
          continue;
        this.e.select(n);
      }
    this.e.addSelectionListener(new at(this));
    Button localButton = f(localComposite2);
    localButton.setText(b("reset.DataDialog"));
    localButton.addSelectionListener(new ax(this));
    this.a = new CTabFolder(localComposite1, 0);
    this.a.setLayoutData(a(490, 340));
    this.a.setLayout(new GridLayout());
    CTabItem localCTabItem = new CTabItem(this.a, 0);
    localCTabItem.setText(b("updatefields.SelectSheetAndFieldsDialog"));
    Composite localComposite3 = new Composite(this.a, 0);
    localComposite3.setLayout(new GridLayout());
    localComposite3.setLayoutData(new GridData(1808));
    Table localTable1 = a(localComposite3, false);
    a(false);
    localCTabItem.setControl(localComposite3);
    localCTabItem = new CTabItem(this.a, 0);
    localCTabItem.setText(b("wherefields.SelectSheetAndFieldsDialog"));
    localComposite3 = new Composite(this.a, 0);
    localComposite3.setLayout(new GridLayout());
    localComposite3.setLayoutData(new GridData(1808));
    Table localTable2 = a(localComposite3, false);
    a(true);
    localCTabItem.setControl(localComposite3);
    localCTabItem = new CTabItem(this.a, 0);
    localCTabItem.setText(b("conditions.SelectSheetAndFieldsDialog"));
    localComposite3 = new Composite(this.a, 0);
    localComposite3.setLayout(new GridLayout());
    localComposite3.setLayoutData(new GridData(1808));
    Table localTable3 = a(localComposite3, true);
    a(localTable3, this.m.getSelectedConditions());
    localCTabItem.setControl(localComposite3);
    this.a.addSelectionListener(new ay(this, localTable1, localTable2, localTable3));
    Composite localComposite4 = new Composite(localComposite1, 0);
    localComposite4.setLayoutData(new GridData(1808));
    localComposite4.setLayout(a(7));
    d(localComposite4);
    b(localComposite1);
    this.a.setSelection(0);
    this.h = localTable1;
    return localComposite1;
  }

  private Table a(Composite paramComposite, boolean paramBoolean)
  {
    this.h = e(paramComposite);
    a(this.h, paramBoolean);
    this.h.addMouseMoveListener(new az(this));
    this.h.addMouseListener(new aA(this));
    return this.h;
  }

  private void h()
  {
    if (this.m.getSourceSheet() == null)
      return;
    Object localObject1;
    Object localObject2;
    TableItem localTableItem;
    IBusinessObject localIBusinessObject;
    if (this.a.getSelectionIndex() == 2)
    {
      localObject1 = new aI(this);
      if ((((aI)localObject1).open() == 0) && (((aI)localObject1).e().length() > 0))
      {
        localObject2 = new SheetWhere(((aI)localObject1).e(), ((aI)localObject1).d());
        this.m.addChildElement((IElement)localObject2);
        ((SheetWhere)localObject2).setValue(((aI)localObject1).b());
        ((SheetWhere)localObject2).setNaryType(((aI)localObject1).a());
        localTableItem = new TableItem(this.h, 0);
        localIBusinessObject = ((aI)localObject1).d();
        localTableItem.setText(1, ((aI)localObject1).e());
        localTableItem.setText(0, localIBusinessObject.getDisplayName());
        localTableItem.setText(2, ((aI)localObject1).b());
        localTableItem.setText(3, ((aI)localObject1).a());
        localTableItem.setData(localObject2);
        this.m.getRoot().setModified(true);
        this.m.update();
      }
    }
    else
    {
      localObject1 = new aF(this);
      if ((((aF)localObject1).open() == 0) && (((aF)localObject1).c() >= 0))
      {
        localObject2 = new SheetFieldMapping(((aF)localObject1).b(), (IBusinessObject)this.l.get(((aF)localObject1).a()));
        if (g())
          ((SheetFieldMapping)localObject2).setMappingType(1);
        this.m.addChildElement((IElement)localObject2);
        localTableItem = new TableItem(this.h, 0);
        localIBusinessObject = (IBusinessObject)this.l.get(((aF)localObject1).a());
        localTableItem.setText(0, ((aF)localObject1).b().getDisplayName() + "-" + ((aF)localObject1).b().getValueName() + "-" + ((aF)localObject1).b().getValueType());
        localTableItem.setText(1, localIBusinessObject.getDisplayName());
        localTableItem.setText(2, localIBusinessObject.getValueType());
        localTableItem.setText(3, localIBusinessObject.getValueName());
        localTableItem.setData(localObject2);
        this.m.getRoot().setModified(true);
        this.m.update();
      }
    }
  }

  private void i()
  {
    if (this.m.getSourceSheet() == null)
      return;
    Object localObject;
    int n;
    if (this.a.getSelectionIndex() == 2)
    {
      localObject = (SheetWhere)j().getData();
      n = -1;
      List localList1 = this.m.getCanSelectSourceFields();
      for (int i2 = 0; i2 < localList1.size(); i2++)
      {
        if (!localList1.get(i2).equals(((SheetWhere)localObject).getField()))
          continue;
        n = i2;
        break;
      }
      if (n < 0)
        return;
      aI localaI = new aI(this, j().getText(1), n, j().getText(2), j().getText(3));
      if ((localaI.open() == 0) && ((!localaI.e().equals(j().getText(2))) || (n != localaI.c()) || (!localaI.b().equals(j().getText(0)))))
      {
        SheetWhere localSheetWhere = (SheetWhere)j().getData();
        localSheetWhere.setFuncName(localaI.e());
        localSheetWhere.setField(localaI.d());
        localSheetWhere.setValue(localaI.b());
        localSheetWhere.setNaryType(localaI.a());
        j().setText(2, localSheetWhere.getValue());
        j().setText(0, localSheetWhere.getField().getDisplayName());
        j().setText(1, localaI.e());
        j().setText(3, localaI.a());
        this.m.getRoot().setModified(true);
        this.m.update();
      }
    }
    else
    {
      localObject = (SheetFieldMapping)j().getData();
      n = -1;
      for (int i1 = 0; i1 < this.l.size(); i1++)
      {
        if (!this.l.get(i1).equals(((SheetFieldMapping)localObject).getField()))
          continue;
        n = i1;
        break;
      }
      List localList2 = this.m.getCanSelectSourceFields();
      int i3 = -1;
      for (int i4 = 0; i4 < localList2.size(); i4++)
      {
        if (!localList2.get(i4).equals(((SheetFieldMapping)localObject).getMappingField()))
          continue;
        i3 = i4;
        break;
      }
      aF localaF = new aF(this, i3, n);
      if ((localaF.open() == 0) && ((i3 != localaF.c()) || (n != localaF.a())))
      {
        SheetFieldMapping localSheetFieldMapping = (SheetFieldMapping)j().getData();
        localSheetFieldMapping.setMappingField(localaF.b());
        localSheetFieldMapping.setField((IBusinessObject)this.l.get(localaF.a()));
        j().setText(0, localaF.b().getDisplayName() + "-" + localaF.b().getValueName() + "-" + localaF.b().getValueType());
        j().setText(1, localSheetFieldMapping.getField().getDisplayName());
        j().setText(2, localSheetFieldMapping.getField().getValueType());
        j().setText(3, localSheetFieldMapping.getField().getValueName());
        this.m.getRoot().setModified(true);
        this.m.update();
      }
    }
  }

  private void a(TableItem paramTableItem, int paramInt)
  {
    CCombo localCCombo = new CCombo(this.h, 8);
    List localList = this.m.getCanSelectSourceFields();
    String[] arrayOfString = (String[])null;
    int n;
    if (paramInt == 0)
    {
      arrayOfString = new String[localList.size()];
      for (n = 0; n < localList.size(); n++)
        arrayOfString[n] = (((IBusinessObject)localList.get(n)).getDisplayName() + "-" + ((IBusinessObject)localList.get(n)).getValueName() + "-" + ((IBusinessObject)localList.get(n)).getValueType());
    }
    else
    {
      arrayOfString = new String[this.l.size()];
      for (n = 0; n < this.l.size(); n++)
        arrayOfString[n] = ((IBusinessObject)this.l.get(n)).getDisplayName();
    }
    localCCombo.setItems(arrayOfString);
    localCCombo.setText(paramTableItem.getText(paramInt));
    if (localCCombo.getItemCount() < 20)
      localCCombo.setVisibleItemCount(localCCombo.getItemCount());
    else
      localCCombo.setVisibleItemCount(20);
    this.d = new TableEditor(this.h);
    this.d.horizontalAlignment = 16384;
    this.d.grabHorizontal = true;
    this.d.minimumWidth = 50;
    this.d.setEditor(localCCombo, paramTableItem, paramInt);
    localCCombo.addFocusListener(new aB(this, localCCombo, paramTableItem, paramInt, localList));
    localCCombo.addTraverseListener(new aC(this, localCCombo, paramTableItem, paramInt, localList));
    localCCombo.setFocus();
  }

  private void d(Composite paramComposite)
  {
    Button localButton1 = f(paramComposite);
    localButton1.setText(b("add.DataDialog"));
    localButton1.addSelectionListener(new aD(this));
    Button localButton2 = f(paramComposite);
    localButton2.setText(b("edit.DataDialog"));
    localButton2.addSelectionListener(new aE(this));
    Button localButton3 = f(paramComposite);
    localButton3.setText(b("delete.DataDialog"));
    localButton3.addSelectionListener(new au(this));
    localButton1 = f(paramComposite);
    localButton1.setText(ResourceTools.getMessage("moveUp.DataDialog"));
    localButton1.addSelectionListener(new av(this));
    Button localButton4 = f(paramComposite);
    localButton4.setText(b("moveDown.DataDialog"));
    localButton4.addSelectionListener(new aw(this));
  }

  private Table e(Composite paramComposite)
  {
    this.h = new Table(paramComposite, 68354);
    GridData localGridData = new GridData();
    localGridData.widthHint = 450;
    localGridData.heightHint = 300;
    this.h.setLayoutData(localGridData);
    this.h.setLinesVisible(true);
    return this.h;
  }

  private void a(Table paramTable, List paramList)
  {
    if (paramList != null)
      for (int n = 0; n < paramList.size(); n++)
      {
        TableItem localTableItem = new TableItem(paramTable, 0);
        SheetWhere localSheetWhere = (SheetWhere)paramList.get(n);
        IBusinessObject localIBusinessObject = localSheetWhere.getField();
        if (localIBusinessObject != null)
        {
          localTableItem.setText(new String[] { localIBusinessObject.getDisplayName(), localSheetWhere.getFuncName(), localSheetWhere.getValue(), localSheetWhere.getNaryType() });
          if (!localIBusinessObject.getParent().equals(this.m.getSourceSheet()))
            localTableItem.setBackground(h.g);
        }
        else
        {
          localTableItem.setText(new String[] { b("notExits.TEXT"), localSheetWhere.getFuncName(), localSheetWhere.getValue(), localSheetWhere.getNaryType() });
          localTableItem.setBackground(h.g);
        }
        localTableItem.setData(localSheetWhere);
      }
  }

  private void a(boolean paramBoolean)
  {
    this.h.removeAll();
    Control[] arrayOfControl = this.h.getChildren();
    for (int n = 0; n < arrayOfControl.length; n++)
      arrayOfControl[n].dispose();
    List localList = null;
    if (paramBoolean)
      localList = this.m.getSelectedWheres();
    else
      localList = this.m.getSelectedFields();
    if (localList != null)
      for (int i1 = 0; i1 < localList.size(); i1++)
      {
        TableItem localTableItem = new TableItem(this.h, 0);
        SheetFieldMapping localSheetFieldMapping = (SheetFieldMapping)localList.get(i1);
        IBusinessObject localIBusinessObject1 = localSheetFieldMapping.getField();
        IBusinessObject localIBusinessObject2 = localSheetFieldMapping.getMappingField();
        String str = null;
        if (localIBusinessObject2 != null)
        {
          str = localIBusinessObject2.getDisplayName() + "-" + localIBusinessObject2.getValueName() + "-" + localIBusinessObject2.getValueType();
        }
        else
        {
          str = b("notExits.TEXT");
          localTableItem.setBackground(h.g);
        }
        if ((localIBusinessObject1 != null) && (localIBusinessObject2 != null))
        {
          localTableItem.setText(new String[] { str, localIBusinessObject1.getDisplayName(), localIBusinessObject1.getValueType(), localIBusinessObject1.getValueName() });
          if (!localIBusinessObject1.getJavaType().a(localIBusinessObject2.getJavaType()))
            localTableItem.setBackground(h.g);
          else if (!localIBusinessObject2.getParent().equals(this.m.getSourceSheet()))
            localTableItem.setBackground(h.g);
        }
        else
        {
          localTableItem.setText(new String[] { str, b("notExits.TEXT"), "", "" });
          localTableItem.setBackground(h.g);
        }
        localTableItem.setData(localSheetFieldMapping);
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
    else
    {
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("mappingfield.SelectSheetAndFieldsDialog"));
      localTableColumn.setWidth(150);
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("field.SelectSheetAndFieldsDialog"));
      localTableColumn.setWidth(145);
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("fieldtype.SelectSheetAndFieldsDialog"));
      localTableColumn.setWidth(85);
      localTableColumn = new TableColumn(paramTable, 0);
      localTableColumn.setText(b("fieldname.SelectSheetAndFieldsDialog"));
      localTableColumn.setWidth(65);
    }
  }

  private TableItem j()
  {
    if (this.h.getSelectionIndex() >= 0)
      return this.h.getSelection()[0];
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
    this.m.update();
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
    return this.h.getSelectionCount() > 0;
  }

  public boolean e()
  {
    return false;
  }

  public void f()
  {
    TableItem[] arrayOfTableItem = this.h.getSelection();
    for (int n = 0; n < arrayOfTableItem.length; n++)
    {
      ((IElement)arrayOfTableItem[n].getData()).dispose();
      arrayOfTableItem[n].dispose();
    }
    this.m.getRoot().setModified(true);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.as
 * JD-Core Version:    0.6.0
 */