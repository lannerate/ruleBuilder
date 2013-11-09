package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.f;
import com.flagleader.builder.widget.h;
import com.flagleader.repository.IElement;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.editen.ISheetDynamicEditen;
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
import org.eclipse.swt.widgets.Text;

public class aK extends f
{
  private static final int b = 450;
  private static final int c = 300;
  private TableEditor d;
  private Combo e;
  private Combo f;
  private Combo g;
  private TableItem h;
  private BuilderManager i;
  private Table j;
  private CTabFolder k;
  private List l;
  private String[] m;
  private String[] n;
  private List o;
  private ISheetDynamicEditen p = null;
  List a;

  public aK(Shell paramShell, ISheetDynamicEditen paramISheetDynamicEditen, BuilderManager paramBuilderManager)
  {
    super(paramShell);
    this.p = paramISheetDynamicEditen;
    this.i = paramBuilderManager;
    this.o = paramISheetDynamicEditen.getCanSelectFields();
    if ((this.o != null) && (this.o.size() > 0))
    {
      this.m = new String[this.o.size()];
      for (i1 = 0; i1 < this.o.size(); i1++)
        this.m[i1] = ((IBusinessObject)this.o.get(i1)).getDisplayName();
    }
    else
    {
      this.m = new String[0];
    }
    this.l = paramISheetDynamicEditen.getCanSelectSources();
    this.n = new String[this.l.size()];
    for (int i1 = 0; i1 < this.l.size(); i1++)
      this.n[i1] = ((IElement)this.l.get(i1)).getDisplayName();
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(2));
    this.e = b(localComposite2, "sheet.SelectSheetDynamicDialog", 2048, 280, 12, 2);
    this.e.setItems(this.n);
    if (this.e.getItemCount() < 20)
      this.e.setVisibleItemCount(this.e.getItemCount());
    else
      this.e.setVisibleItemCount(20);
    if (this.p.getSourceSheet() != null)
      for (int i1 = 0; i1 < this.l.size(); i1++)
      {
        if (!this.p.getSourceSheet().equals(this.l.get(i1)))
          continue;
        this.e.select(i1);
      }
    this.e.addSelectionListener(new aL(this));
    this.f = b(localComposite2, "field.SelectSheetDynamicDialog", 2048, 280, 12, 2);
    this.a = this.p.getCanSelectSourceFields();
    this.f.addSelectionListener(new aR(this));
    this.g = b(localComposite2, "value.SelectSheetDynamicDialog", 2048, 280, 12, 2);
    if (this.a != null)
    {
      localObject = new String[this.a.size()];
      for (int i2 = 0; i2 < this.a.size(); i2++)
        localObject[i2] = ((IElement)this.a.get(i2)).getDisplayName();
      this.f.setItems(localObject);
      if (this.f.getItemCount() < 20)
        this.f.setVisibleItemCount(this.f.getItemCount());
      else
        this.f.setVisibleItemCount(20);
      if (this.p.getSheetField() != null)
        for (i2 = 0; i2 < this.a.size(); i2++)
        {
          if (!this.p.getSheetField().equals(this.a.get(i2)))
            continue;
          this.f.select(i2);
        }
      this.g.setItems(localObject);
      if (this.g.getItemCount() < 20)
        this.g.setVisibleItemCount(this.g.getItemCount());
      else
        this.g.setVisibleItemCount(20);
      if (this.p.getSheetValue() != null)
        for (i2 = 0; i2 < this.a.size(); i2++)
        {
          if (!this.p.getSheetValue().equals(this.a.get(i2)))
            continue;
          this.g.select(i2);
        }
    }
    this.g.addSelectionListener(new aS(this));
    this.k = new CTabFolder(localComposite1, 0);
    this.k.setLayoutData(a(490, 340));
    this.k.setLayout(new GridLayout());
    Object localObject = new CTabItem(this.k, 0);
    ((CTabItem)localObject).setText(b("allmappings.SelectSheetDynamicDialog"));
    Composite localComposite3 = new Composite(this.k, 0);
    localComposite3.setLayout(new GridLayout());
    localComposite3.setLayoutData(new GridData(1808));
    Table localTable = a(localComposite3, false);
    j();
    ((CTabItem)localObject).setControl(localComposite3);
    Composite localComposite4 = new Composite(localComposite1, 0);
    localComposite4.setLayoutData(new GridData(1808));
    localComposite4.setLayout(a(7));
    d(localComposite4);
    b(localComposite1);
    this.k.setSelection(0);
    this.j = localTable;
    return (Control)localComposite1;
  }

  private boolean g()
  {
    return this.k.getSelectionIndex() == 1;
  }

  private Table a(Composite paramComposite, boolean paramBoolean)
  {
    this.j = e(paramComposite);
    a(this.j, paramBoolean);
    this.d = new TableEditor(this.j);
    this.j.addMouseMoveListener(new aT(this));
    this.j.addMouseListener(new aU(this));
    return this.j;
  }

  private void h()
  {
    Object localObject1;
    Object localObject2;
    TableItem localTableItem;
    IBusinessObject localIBusinessObject;
    if (this.k.getSelectionIndex() == 0)
    {
      localObject1 = new aZ(this);
      if ((((aZ)localObject1).open() == 0) && (((aZ)localObject1).c() >= 0))
      {
        localObject2 = new SheetFieldMapping(((aZ)localObject1).b(), (IBusinessObject)this.o.get(((aZ)localObject1).a()));
        this.p.addChildElement((IElement)localObject2);
        localTableItem = new TableItem(this.j, 0);
        localIBusinessObject = (IBusinessObject)this.o.get(((aZ)localObject1).a());
        localTableItem.setText(0, ((aZ)localObject1).b().getDisplayName() + "-" + ((aZ)localObject1).b().getValueName() + "-" + ((aZ)localObject1).b().getValueType());
        localTableItem.setText(1, localIBusinessObject.getDisplayName());
        localTableItem.setText(2, localIBusinessObject.getValueType());
        localTableItem.setText(3, localIBusinessObject.getValueName());
        localTableItem.setData(localObject2);
        this.p.getRoot().setModified(true);
        this.p.update();
      }
    }
    else if (this.k.getSelectionIndex() == 1)
    {
      localObject1 = new bc(this);
      if ((((bc)localObject1).open() == 0) && (((bc)localObject1).e().length() > 0))
      {
        localObject2 = new SheetWhere(((bc)localObject1).e(), ((bc)localObject1).d());
        this.p.addChildElement((IElement)localObject2);
        ((SheetWhere)localObject2).setValue(((bc)localObject1).b());
        ((SheetWhere)localObject2).setNaryType(((bc)localObject1).a());
        localTableItem = new TableItem(this.j, 0);
        localIBusinessObject = ((bc)localObject1).d();
        localTableItem.setText(1, ((bc)localObject1).e());
        localTableItem.setText(0, localIBusinessObject.getDisplayName());
        localTableItem.setText(2, ((bc)localObject1).b());
        localTableItem.setText(3, ((bc)localObject1).a());
        localTableItem.setData(localObject2);
        this.p.getRoot().setModified(true);
        this.p.update();
      }
    }
  }

  private void i()
  {
    Object localObject1;
    int i1;
    List localList;
    int i3;
    Object localObject2;
    if (this.k.getSelectionIndex() == 0)
    {
      localObject1 = (SheetFieldMapping)k().getData();
      i1 = -1;
      for (int i2 = 0; i2 < this.o.size(); i2++)
      {
        if (!this.o.get(i2).equals(((SheetFieldMapping)localObject1).getField()))
          continue;
        i1 = i2;
        break;
      }
      localList = this.p.getCanSelectSourceFields();
      i3 = -1;
      for (int i4 = 0; i4 < localList.size(); i4++)
      {
        if (!localList.get(i4).equals(((SheetFieldMapping)localObject1).getMappingField()))
          continue;
        i3 = i4;
        break;
      }
      localObject2 = new aZ(this, i3, i1);
      if ((((aZ)localObject2).open() == 0) && ((i3 != ((aZ)localObject2).c()) || (i1 != ((aZ)localObject2).a())))
      {
        SheetFieldMapping localSheetFieldMapping = (SheetFieldMapping)k().getData();
        localSheetFieldMapping.setMappingField(((aZ)localObject2).b());
        localSheetFieldMapping.setField((IBusinessObject)this.o.get(((aZ)localObject2).a()));
        k().setText(0, ((aZ)localObject2).b().getDisplayName() + "-" + ((aZ)localObject2).b().getValueName() + "-" + ((aZ)localObject2).b().getValueType());
        k().setText(1, localSheetFieldMapping.getField().getDisplayName());
        k().setText(2, localSheetFieldMapping.getField().getValueType());
        k().setText(3, localSheetFieldMapping.getField().getValueName());
        this.p.getRoot().setModified(true);
        this.p.update();
      }
    }
    else if (this.k.getSelectionIndex() == 1)
    {
      localObject1 = (SheetWhere)k().getData();
      i1 = -1;
      localList = this.p.getCanSelectSourceFields();
      for (i3 = 0; i3 < localList.size(); i3++)
      {
        if (!localList.get(i3).equals(((SheetWhere)localObject1).getField()))
          continue;
        i1 = i3;
        break;
      }
      if (i1 < 0)
        return;
      bc localbc = new bc(this, k().getText(1), i1, k().getText(2), k().getText(3));
      if ((localbc.open() == 0) && ((!localbc.e().equals(k().getText(2))) || (i1 != localbc.c()) || (!localbc.b().equals(k().getText(0)))))
      {
        localObject2 = (SheetWhere)k().getData();
        ((SheetWhere)localObject2).setFuncName(localbc.e());
        ((SheetWhere)localObject2).setField(localbc.d());
        ((SheetWhere)localObject2).setValue(localbc.b());
        ((SheetWhere)localObject2).setNaryType(localbc.a());
        k().setText(2, ((SheetWhere)localObject2).getValue());
        k().setText(0, ((SheetWhere)localObject2).getField().getDisplayName());
        k().setText(1, localbc.e());
        k().setText(3, localbc.a());
        this.p.getRoot().setModified(true);
        this.p.update();
      }
    }
  }

  private void a(TableItem paramTableItem, Text paramText, TableEditor paramTableEditor, int paramInt)
  {
    paramText.setFont(this.j.getFont());
    paramText.selectAll();
    paramTableEditor.horizontalAlignment = 16384;
    paramTableEditor.grabHorizontal = true;
    paramTableEditor.setEditor(paramText, this.h, paramInt);
    paramText.addFocusListener(new aV(this, paramText, paramTableItem, paramInt, paramTableEditor));
    paramText.addTraverseListener(new aW(this, paramText, paramTableItem, paramInt, paramTableEditor));
  }

  private void a(TableItem paramTableItem, int paramInt)
  {
    CCombo localCCombo = new CCombo(this.j, 8);
    List localList = this.p.getCanSelectSourceFields();
    String[] arrayOfString = (String[])null;
    int i1;
    if (paramInt == 0)
    {
      arrayOfString = new String[localList.size()];
      for (i1 = 0; i1 < localList.size(); i1++)
        arrayOfString[i1] = (((IBusinessObject)localList.get(i1)).getDisplayName() + "-" + ((IBusinessObject)localList.get(i1)).getValueName() + "-" + ((IBusinessObject)localList.get(i1)).getValueType());
    }
    else
    {
      arrayOfString = new String[this.o.size()];
      for (i1 = 0; i1 < this.o.size(); i1++)
        arrayOfString[i1] = ((IBusinessObject)this.o.get(i1)).getDisplayName();
    }
    localCCombo.setItems(arrayOfString);
    localCCombo.setText(paramTableItem.getText(paramInt));
    if (localCCombo.getItemCount() < 20)
      localCCombo.setVisibleItemCount(localCCombo.getItemCount());
    else
      localCCombo.setVisibleItemCount(20);
    this.d.horizontalAlignment = 16384;
    this.d.grabHorizontal = true;
    this.d.minimumWidth = 50;
    this.d.setEditor(localCCombo, paramTableItem, paramInt);
    localCCombo.addFocusListener(new aX(this, localCCombo, paramTableItem, paramInt, localList));
    localCCombo.addTraverseListener(new aY(this, localCCombo, paramTableItem, paramInt, localList));
    localCCombo.setFocus();
  }

  private void d(Composite paramComposite)
  {
    Button localButton1 = f(paramComposite);
    localButton1.setText(b("add.DataDialog"));
    localButton1.addSelectionListener(new aM(this));
    Button localButton2 = f(paramComposite);
    localButton2.setText(b("edit.DataDialog"));
    localButton2.addSelectionListener(new aN(this));
    Button localButton3 = f(paramComposite);
    localButton3.setText(b("delete.DataDialog"));
    localButton3.addSelectionListener(new aO(this));
    localButton1 = f(paramComposite);
    localButton1.setText(ResourceTools.getMessage("moveUp.DataDialog"));
    localButton1.addSelectionListener(new aP(this));
    Button localButton4 = f(paramComposite);
    localButton4.setText(b("moveDown.DataDialog"));
    localButton4.addSelectionListener(new aQ(this));
  }

  private Table e(Composite paramComposite)
  {
    Table localTable = new Table(paramComposite, 68354);
    GridData localGridData = new GridData();
    localGridData.widthHint = 450;
    localGridData.heightHint = 300;
    localTable.setLayoutData(localGridData);
    localTable.setLinesVisible(true);
    return localTable;
  }

  private void a(Table paramTable, List paramList)
  {
    if (paramList != null)
      for (int i1 = 0; i1 < paramList.size(); i1++)
      {
        TableItem localTableItem = new TableItem(paramTable, 0);
        SheetWhere localSheetWhere = (SheetWhere)paramList.get(i1);
        IBusinessObject localIBusinessObject = localSheetWhere.getField();
        if (localIBusinessObject != null)
        {
          localTableItem.setText(new String[] { localIBusinessObject.getDisplayName(), localSheetWhere.getFuncName(), localSheetWhere.getValue(), localSheetWhere.getNaryType() });
          if (!localIBusinessObject.getParent().equals(this.p.getSourceSheet()))
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

  private void j()
  {
    this.j.removeAll();
    Control[] arrayOfControl = this.j.getChildren();
    for (int i1 = 0; i1 < arrayOfControl.length; i1++)
      arrayOfControl[i1].dispose();
    List localList = this.p.getSelectedFields();
    if (localList != null)
      for (int i2 = 0; i2 < localList.size(); i2++)
      {
        TableItem localTableItem = new TableItem(this.j, 0);
        SheetFieldMapping localSheetFieldMapping = (SheetFieldMapping)localList.get(i2);
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
          else if (!localIBusinessObject2.getParent().equals(this.p.getSourceSheet()))
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

  private TableItem k()
  {
    if (this.j.getSelectionIndex() >= 0)
      return this.j.getSelection()[0];
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
    this.p.update();
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
    return this.j.getSelectionCount() > 0;
  }

  public boolean e()
  {
    return false;
  }

  public void f()
  {
    TableItem[] arrayOfTableItem = this.j.getSelection();
    for (int i1 = 0; i1 < arrayOfTableItem.length; i1++)
    {
      ((IElement)arrayOfTableItem[i1].getData()).dispose();
      arrayOfTableItem[i1].dispose();
    }
    this.p.getRoot().setModified(true);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.aK
 * JD-Core Version:    0.6.0
 */