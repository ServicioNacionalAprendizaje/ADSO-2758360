import axios from 'axios';
import { API_BASE_URL } from './api-config';

const SERVICIO_CLIENTE_API_URL = `${API_BASE_URL}/servicioCliente`;

interface ServicioClienteData {
  cantidad: number;
  totalPagar: number;
  clienteId: { id: number };
  servicioId: { id: number };
}

export const getAllServiciosCliente = async (): Promise<any> => {
  try {
    const { data } = await axios.get(SERVICIO_CLIENTE_API_URL);
    return data;
  } catch (error) {
    console.error('Error al obtener servicios del cliente:', error);
    throw error;
  }
};

export const findServicioClienteById = async (id: number): Promise<any> => {
  try {
    const { data } = await axios.get(`${SERVICIO_CLIENTE_API_URL}/${id}`);
    return data;
  } catch (error) {
    console.error(`Error al obtener servicio del cliente ID ${id}:`, error);
    throw error;
  }
};

export const saveServicioCliente = async (servicioClienteData: ServicioClienteData): Promise<any> => {
  try {
    const { data } = await axios.post(SERVICIO_CLIENTE_API_URL, servicioClienteData);
    return data;
  } catch (error) {
    console.error('Error al guardar servicio del cliente:', error);
    throw error;
  }
};

export const updateServicioCliente = async (servicioClienteData: ServicioClienteData, id: number): Promise<any> => {
  try {
    const { data } = await axios.put(`${SERVICIO_CLIENTE_API_URL}/${id}`, servicioClienteData);
    return data;
  } catch (error) {
    console.error(`Error al actualizar servicio del cliente ID ${id}:`, error);
    throw error;
  }
};

export const deleteServicioCliente = async (id: number): Promise<any> => {
  try {
    const { data } = await axios.delete(`${SERVICIO_CLIENTE_API_URL}/${id}`);
    return data;
  } catch (error) {
    console.error(`Error al eliminar servicio del cliente ID ${id}:`, error);
    throw error;
  }
};